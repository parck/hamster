package cn.edots.hamster.alibaba.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import com.aliyun.oss.model.ObjectMetadata;

import java.io.*;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;

public class OSS {

    protected static final String OSS_CN_HANGZHOU = "oss-cn-hangzhou.aliyuncs.com";
    protected static final String OSS_CN_SHANGHAI = "oss-cn-shanghai.aliyuncs.com";
    protected static final String OSS_CN_QINGDAO = "oss-cn-qingdao.aliyuncs.com";
    protected static final String OSS_CN_BEIJING = "oss-cn-beijing.aliyuncs.com";
    protected static final String OSS_CN_ZHANGJIAKOU = "oss-cn-zhangjiakou.aliyuncs.com";
    protected static final String OSS_CN_HUHEHAOTE = "oss-cn-huhehaote.aliyuncs.com";
    protected static final String OSS_CN_SHENZHEN = "oss-cn-shenzhen.aliyuncs.com";
    protected static final String OSS_CN_HONGKONG = "oss-cn-hongkong.aliyuncs.com";
    protected static final String OSS_US_WEST_1 = "oss-us-west-1.aliyuncs.com";
    protected static final String OSS_US_EAST_1 = "oss-us-east-1.aliyuncs.com";
    protected static final String OSS_AP_SOUTHEAST_1 = "oss-ap-southeast-1.aliyuncs.com";
    protected static final String OSS_AP_SOUTHEAST_2 = "oss-ap-southeast-2.aliyuncs.com";
    protected static final String OSS_AP_SOUTHEAST_3 = "oss-ap-southeast-3.aliyuncs.com";
    protected static final String OSS_AP_NORTHEAST_1 = "oss-ap-northeast-1.aliyuncs.com";
    protected static final String OSS_AP_SOUTH_1 = "oss-ap-south-1.aliyuncs.com";
    protected static final String OSS_EU_CENTRAL_1 = "oss-eu-central-1.aliyuncs.com";
    protected static final String OSS_ME_EAST_1 = "oss-me-east-1.aliyuncs.com";
    
    protected String bucket;
    protected final OSSClient client;

    public OSS(String endpoint, String key, String secret, String bucket) {
        client = new OSSClient(endpoint, key, secret);
        this.bucket = bucket;
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

    public String getURL(String key) throws ParseException {
        Date expires = new Date(new Date().getTime() + 1000 * 60 * 60 * 24);
        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucket, key);
        generatePresignedUrlRequest.setExpiration(expires);

        URL url = client.generatePresignedUrl(generatePresignedUrlRequest);

        String resultUrl = url.toString();
        return resultUrl;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public OSSClient getClient() {
        return client;
    }
}
