package com.example.K2426Project3.repository;

import com.example.K2426Project3.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(nativeQuery = true, value = "SELECT P.*, C.CNAME FROM PRODUCT P ,CATEGORY C WHERE P.CID = C.CID")
    List<Map<String, Object>> getProductList();

    @Query(nativeQuery = true, value = "SELECT P.*, C.CNAME FROM PRODUCT P ," +
            "CATEGORY C WHERE P.CID = C.CID and p.pname like :pname")
    List<Map<String, Object>> findProduct(String pname);

    List<Product> searchProductsByPname(String pname);

    boolean existsByPid(int pid);

}
