package com.ecorn.webshop.service;

import com.ecorn.webshop.dto.BucketDTO;
import com.ecorn.webshop.entity.Bucket;
import com.ecorn.webshop.entity.User;

import java.util.List;

public interface BucketService {
    Bucket createBucket(User user, List<Long> productIds);

    void addProducts(Bucket bucket, List<Long> productIds);

    BucketDTO getBucketByUser(String name);
    void commitBucketToOrder(String username);
}
