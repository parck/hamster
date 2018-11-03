package cn.edots.hamster.alibaba.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.auth.sts.AssumeRoleRequest;
import com.aliyuncs.auth.sts.AssumeRoleResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import java.io.*;
import java.net.URL;
import java.util.Date;

public class AliOSS {

    public static final String OSS_CN_HANGZHOU = "oss-cn-hangzhou.aliyuncs.com";
    public static final String OSS_CN_SHANGHAI = "oss-cn-shanghai.aliyuncs.com";
    public static final String OSS_CN_QINGDAO = "oss-cn-qingdao.aliyuncs.com";
    public static final String OSS_CN_BEIJING = "oss-cn-beijing.aliyuncs.com";
    public static final String OSS_CN_ZHANGJIAKOU = "oss-cn-zhangjiakou.aliyuncs.com";
    public static final String OSS_CN_HUHEHAOTE = "oss-cn-huhehaote.aliyuncs.com";
    public static final String OSS_CN_SHENZHEN = "oss-cn-shenzhen.aliyuncs.com";
    public static final String OSS_CN_HONGKONG = "oss-cn-hongkong.aliyuncs.com";
    public static final String OSS_US_WEST_1 = "oss-us-west-1.aliyuncs.com";
    public static final String OSS_US_EAST_1 = "oss-us-east-1.aliyuncs.com";
    public static final String OSS_AP_SOUTHEAST_1 = "oss-ap-southeast-1.aliyuncs.com";
    public static final String OSS_AP_SOUTHEAST_2 = "oss-ap-southeast-2.aliyuncs.com";
    public static final String OSS_AP_SOUTHEAST_3 = "oss-ap-southeast-3.aliyuncs.com";
    public static final String OSS_AP_NORTHEAST_1 = "oss-ap-northeast-1.aliyuncs.com";
    public static final String OSS_AP_SOUTH_1 = "oss-ap-south-1.aliyuncs.com";
    public static final String OSS_EU_CENTRAL_1 = "oss-eu-central-1.aliyuncs.com";
    public static final String OSS_ME_EAST_1 = "oss-me-east-1.aliyuncs.com";

    protected String bucket;
    protected String endpoint;
    protected String key;
    protected String secret;
    protected OSSClient client;

    public AliOSS(OSSClient client, String bucket) {
        this.client = client;
        this.bucket = bucket;
    }

    public AliOSS(String endpoint, String key, String secret, String bucket) {
        this.client = new OSSClient(endpoint, key, secret);
        this.bucket = bucket;
        this.endpoint = endpoint;
        this.key = key;
    }

    public STSAccessResult access(STSAccessParameter parameter) {
        STSAccessResult result = new STSAccessResult();
        try {
            DefaultProfile.addEndpoint("", "", "Sts", parameter.getEndpoint());
            IClientProfile profile = DefaultProfile.getProfile("", parameter.getKey(), parameter.getSecret());
            DefaultAcsClient client = new DefaultAcsClient(profile);
            final AssumeRoleRequest request = new AssumeRoleRequest();
            request.setMethod(MethodType.POST);
            request.setRoleArn(parameter.getArn());
            request.setRoleSessionName(parameter.getName());
            final AssumeRoleResponse response = client.getAcsResponse(request);
            AssumeRoleResponse.Credentials credentials = response.getCredentials();
            result.setId(response.getRequestId());
            result.setKey(credentials.getAccessKeyId());
            result.setSecret(credentials.getAccessKeySecret());
            result.setToken(credentials.getSecurityToken());
            result.setExpiration(credentials.getExpiration());
        } catch (ClientException e) {
            result.setId(e.getRequestId());
            result.setErrorCode(e.getErrCode());
            result.setErrorMessage(e.getErrMsg());
        }
        return result;
    }

    public String upload(String key, InputStream in) throws IOException {
        while (key.startsWith("/")) {
            key = key.substring(1);
        }
        ObjectMetadata meta = new ObjectMetadata();
        meta.setContentLength(in.available());
        meta.setLastModified(new Date());
        return client.putObject(bucket, key, in, meta).getETag();
    }

    public String upload(String key, File file) throws FileNotFoundException {
        while (key.startsWith("/")) {
            key = key.substring(1);
        }
        ObjectMetadata meta = new ObjectMetadata();
        meta.setContentLength(file.length());
        meta.setLastModified(new Date(file.lastModified()));
        return client.putObject(bucket, key, new FileInputStream(file), meta).getETag();
    }

    public String upload(String key, InputStream in, Metadata metadata) throws IOException {
        while (key.startsWith("/")) {
            key = key.substring(1);
        }
        ObjectMetadata meta = metadata.toObjectMetadata();
        meta.setContentLength(in.available());
        meta.setLastModified(new Date());
        return client.putObject(bucket, key, in, meta).getETag();
    }

    public String upload(String key, File file, Metadata metadata) throws FileNotFoundException {
        while (key.startsWith("/")) {
            key = key.substring(1);
        }
        ObjectMetadata meta = metadata.toObjectMetadata();
        meta.setContentLength(file.length());
        meta.setLastModified(new Date(file.lastModified()));
        return client.putObject(bucket, key, new FileInputStream(file), meta).getETag();
    }

    public String getURL(String key) {
        Date expires = new Date(new Date().getTime() + 1000 * 60 * 60 * 24);
        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucket, key);
        generatePresignedUrlRequest.setExpiration(expires);

        URL url = client.generatePresignedUrl(generatePresignedUrlRequest);

        return url.toString();
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public OSSClient getClient() {
        return client;
    }
}
