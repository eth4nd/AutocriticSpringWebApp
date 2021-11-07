package com.autocritic.autocriticspringbootproj.buckets;

public enum BucketName {
    PROFILE_IMAGE("autocritic.com");
    private final String bucketName;

    BucketName(String bucketName){
        this.bucketName = bucketName;
    }

    public String getBucketName(){
        return bucketName;
    }
}
