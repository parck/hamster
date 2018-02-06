package cn.edots.hamster.alibaba.oss;

import com.aliyun.oss.model.ObjectMetadata;

import java.util.Date;

public class Metadata {

    private Date lastModified;
    private Date expirationTime;
    private long contentLength;
    private String contentType;
    private String contentMD5;
    private String contentEncoding;
    private String cacheControl;
    private String contentDisposition;

    public ObjectMetadata toObjectMetadata() {
        ObjectMetadata metadata = new ObjectMetadata();
        if (lastModified != null) metadata.setLastModified(lastModified);
        if (expirationTime != null) metadata.setExpirationTime(expirationTime);
        if (contentLength > 0) metadata.setContentLength(contentLength);
        if (contentType != null && contentType.trim().length() > 0) metadata.setContentType(contentType);
        if (contentMD5 != null && contentMD5.trim().length() > 0) metadata.setContentMD5(contentMD5);
        if (contentEncoding != null && contentEncoding.trim().length() > 0)
            metadata.setContentEncoding(contentEncoding);
        if (cacheControl != null && cacheControl.trim().length() > 0) metadata.setCacheControl(cacheControl);
        if (contentDisposition != null && contentDisposition.trim().length() > 0)
            metadata.setContentDisposition(contentDisposition);
        return metadata;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentMD5() {
        return contentMD5;
    }

    public void setContentMD5(String contentMD5) {
        this.contentMD5 = contentMD5;
    }

    public String getContentEncoding() {
        return contentEncoding;
    }

    public void setContentEncoding(String contentEncoding) {
        this.contentEncoding = contentEncoding;
    }

    public String getCacheControl() {
        return cacheControl;
    }

    public void setCacheControl(String cacheControl) {
        this.cacheControl = cacheControl;
    }

    public String getContentDisposition() {
        return contentDisposition;
    }

    public void setContentDisposition(String contentDisposition) {
        this.contentDisposition = contentDisposition;
    }

}