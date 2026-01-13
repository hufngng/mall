package com.macro.mall.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dto.BucketPolicyConfigDto;
import com.macro.mall.dto.MinioUploadDto;
import io.minio.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * MinIO Object Storage Management Controller
 * Created by macro on 2019/12/25.
 */
@Controller
@Api(tags = "MinioController")
@Tag(name = "MinioController", description = "MinIO Object Storage Management")
@RequestMapping("/minio")
public class MinioController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MinioController.class);
    @Value("${minio.endpoint}")
    private String ENDPOINT;
    @Value("${minio.bucketName}")
    private String BUCKET_NAME;
    @Value("${minio.accessKey}")
    private String ACCESS_KEY;
    @Value("${minio.secretKey}")
    private String SECRET_KEY;

    @ApiOperation("File upload")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult upload(@RequestPart("file") MultipartFile file) {
        try {
            // Create a MinIO Java client
            MinioClient minioClient =MinioClient.builder()
                    .endpoint(ENDPOINT)
                    .credentials(ACCESS_KEY,SECRET_KEY)
                    .build();
            boolean isExist = minioClient.bucketExists(BucketExistsArgs.builder().bucket(BUCKET_NAME).build());
            if (isExist) {
                LOGGER.info("Bucket already exists!");
            } else {
                // Create the bucket and set read-only policy
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(BUCKET_NAME).build());
                BucketPolicyConfigDto bucketPolicyConfigDto = createBucketPolicyConfigDto(BUCKET_NAME);
                SetBucketPolicyArgs setBucketPolicyArgs = SetBucketPolicyArgs.builder()
                        .bucket(BUCKET_NAME)
                        .config(JSONUtil.toJsonStr(bucketPolicyConfigDto))
                        .build();
                minioClient.setBucketPolicy(setBucketPolicyArgs);
            }
            String filename = file.getOriginalFilename();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            // Set the storage object name
            String objectName = sdf.format(new Date()) + "/" + filename;
            // Upload a file to the bucket using putObject
            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                    .bucket(BUCKET_NAME)
                    .object(objectName)
                    .contentType(file.getContentType())
                    .stream(file.getInputStream(), file.getSize(), ObjectWriteArgs.MIN_MULTIPART_SIZE).build();
            minioClient.putObject(putObjectArgs);
            LOGGER.info("File uploaded successfully!");
            MinioUploadDto minioUploadDto = new MinioUploadDto();
            minioUploadDto.setName(filename);
            minioUploadDto.setUrl(ENDPOINT + "/" + BUCKET_NAME + "/" + objectName);
            return CommonResult.success(minioUploadDto);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("Upload error: {}!", e.getMessage());
        }
        return CommonResult.failed();
    }

    /**
     * Create access policy for the bucket, set to read-only
     */
    private BucketPolicyConfigDto createBucketPolicyConfigDto(String bucketName) {
        BucketPolicyConfigDto.Statement statement = BucketPolicyConfigDto.Statement.builder()
                .Effect("Allow")
                .Principal("*")
                .Action("s3:GetObject")
                .Resource("arn:aws:s3:::"+bucketName+"/*.**").build();
        return BucketPolicyConfigDto.builder()
                .Version("2012-10-17")
                .Statement(CollUtil.toList(statement))
                .build();
    }

    @ApiOperation("Delete file")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("objectName") String objectName) {
        try {
            MinioClient minioClient = MinioClient.builder()
                    .endpoint(ENDPOINT)
                    .credentials(ACCESS_KEY,SECRET_KEY)
                    .build();
            minioClient.removeObject(RemoveObjectArgs.builder().bucket(BUCKET_NAME).object(objectName).build());
            return CommonResult.success(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CommonResult.failed();
    }
}
