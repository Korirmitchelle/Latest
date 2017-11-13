/*
 * Copyright (c) 2017. http://hiteshsahu.com- All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * If you use or distribute this project then you MUST ADD A COPY OF LICENCE
 * along with the project.
 *  Written by Hitesh Sahu <hiteshkrsahu@Gmail.com>, 2017.
 */

package com.mitchy.retailapp.domain.mock;

import com.mitchy.retailapp.model.CenterRepository;
import com.mitchy.retailapp.model.entities.Product;
import com.mitchy.retailapp.model.entities.ProductCategoryModel;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/*
 * This class serve as fake server and provides dummy product and category with real Image Urls taken from killimall and jumia
 */
public class FakeWebServer {

    private static FakeWebServer fakeServer;

    public static FakeWebServer getFakeWebServer() {

        if (null == fakeServer) {
            fakeServer = new FakeWebServer();
        }
        return fakeServer;
    }

    void initiateFakeServer() {

        addCategory();

    }

    public void addCategory() {

        ArrayList<ProductCategoryModel> listOfCategory = new ArrayList<ProductCategoryModel>();

        listOfCategory
                .add(new ProductCategoryModel(
                        "Computing",
                        "Computing Items",
                        "10%",
                        "https://ke.jumia.is/zCg8Rm4LZvOlKiV1MSIuhGQGy8w=/fit-in/220x220/filters:fill(white)/product/15/2687/1.jpg?5442"));

        listOfCategory
                .add(new ProductCategoryModel(
                        "Women's Fashion",
                        "For all you ladies!",
                        "15%",
                        "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/591/2016/10/591_05295164459337231_360.jpg"));

        listOfCategory
                .add(new ProductCategoryModel(
                        "Phones & Accessories",
                        "Find the best quality",
                        "18%",
                        "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/1065/2017/04/1065_05450860097009944_1280.jpg"));
        listOfCategory
        .add(new ProductCategoryModel(
                "Baby, Kids and Toys",
                "Find the best quality",
                "18%",
                "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/749/2016/09/749_05276227447579283_360.jpg"));




        CenterRepository.getCenterRepository().setListOfCategory(listOfCategory);
    }

    public void getAllElectronics() {

        ConcurrentHashMap<String, ArrayList<Product>> productMap = new ConcurrentHashMap<String, ArrayList<Product>>();

        ArrayList<Product> productlist = new ArrayList<Product>();

        // Ovens
        productlist
                .add(new Product(
                        "Laptops",
                        "Lenovo Ideapad 110 15.6\" - Intel Celeron - N3060 - 500GB HDD - 4GB RAM ",
                        "Lenovo Ideapad 110 15.6\" - Intel Celeron - N3060 - 500GB HDD - 4GB RAM - No OS Installed - Black Black 15.6\n" +
                                "Screen Size: 15.6 inch Screen Type: HD LED OS: DOS Intel Celeron N3060 Storage: 500GB Harddisk, 4GB RAM",
                        "30678",
                        "10",
                        "27698",
                        "0",
                        "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/892/2016/10/892_05286562169827581_360.jpg",
                        "oven_1"));

        productlist
                .add(new Product(
                        "Laptops",
                        "Lenovo Ideapad 110 15.6\" - Intel Celeron - N3060 - 500GB HDD - 4GB RAM ",
                        "Lenovo Ideapad 110 15.6\" - Intel Celeron - N3060 - 500GB HDD - 4GB RAM - No OS Installed - Black Black 15.6\n" +
                                "Screen Size: 15.6 inch Screen Type: HD LED OS: DOS Intel Celeron N3060 Storage: 500GB Harddisk, 4GB RAM",
                        "30678",
                        "10",
                        "27698",
                        "0",
                        "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/892/2016/10/892_05286562169827581_360.jpg",
                        "oven_1"));

        productlist
                .add(new Product(
                        "Laptops",
                        "Lenovo Ideapad 110 15.6\" - Intel Celeron - N3060 - 500GB HDD - 4GB RAM ",
                        "Lenovo Ideapad 110 15.6\" - Intel Celeron - N3060 - 500GB HDD - 4GB RAM - No OS Installed - Black Black 15.6\n" +
                                "Screen Size: 15.6 inch Screen Type: HD LED OS: DOS Intel Celeron N3060 Storage: 500GB Harddisk, 4GB RAM",
                        "30678",
                        "10",
                        "27698",
                        "0",
                        "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/892/2016/10/892_05286562169827581_360.jpg",
                        "oven_1"));

        productlist
                .add(new Product(
                        "Laptops",
                        "Lenovo Ideapad 110 15.6\" - Intel Celeron - N3060 - 500GB HDD - 4GB RAM ",
                        "Lenovo Ideapad 110 15.6\" - Intel Celeron - N3060 - 500GB HDD - 4GB RAM - No OS Installed - Black Black 15.6\n" +
                                "Screen Size: 15.6 inch Screen Type: HD LED OS: DOS Intel Celeron N3060 Storage: 500GB Harddisk, 4GB RAM",
                        "30678",
                        "10",
                        "27698",
                        "0",
                        "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/892/2016/10/892_05286562169827581_360.jpg",
                        "oven_1"));

        productlist
                .add(new Product(
                        "Laptops",
                        "Lenovo Ideapad 110 15.6\" - Intel Celeron - N3060 - 500GB HDD - 4GB RAM ",
                        "Lenovo Ideapad 110 15.6\" - Intel Celeron - N3060 - 500GB HDD - 4GB RAM - No OS Installed - Black Black 15.6\n" +
                                "Screen Size: 15.6 inch Screen Type: HD LED OS: DOS Intel Celeron N3060 Storage: 500GB Harddisk, 4GB RAM",
                        "30678",
                        "10",
                        "27698",
                        "0",
                        "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/892/2016/10/892_05286562169827581_360.jpg",
                        "oven_1"));

        productMap.put("Laptops", productlist);

        ArrayList<Product> tvList = new ArrayList<Product>();

        // TV
        tvList.add(new Product(
                "HP",
                "HP DESKTOP 280( K8K31EA)CI3",
                "NMICRO TOWER/CI3(3.6GHZ),4GB RAM,500GB,DOS",
                "65748",
                "12",
                "61520",
                "0",
                "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/385/2016/04/385_05138066843106823_360.jpg",
                "tv_1"));

        tvList.add(new Product(
                "HP",
                "HP DESKTOP 280( K8K31EA)CI3",
                "NMICRO TOWER/CI3(3.6GHZ),4GB RAM,500GB,DOS",
                "65748",
                "12",
                "61520",
                "0",
                "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/385/2016/04/385_05138066843106823_360.jpg",
                "tv_1"));

        tvList.add(new Product(
                "HP",
                "HP DESKTOP 280( K8K31EA)CI3",
                "NMICRO TOWER/CI3(3.6GHZ),4GB RAM,500GB,DOS",
                "65748",
                "12",
                "61520",
                "0",
                "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/385/2016/04/385_05138066843106823_360.jpg",
                "tv_1"));

        tvList.add(new Product(
                "HP",
                "HP DESKTOP 280( K8K31EA)CI3",
                "NMICRO TOWER/CI3(3.6GHZ),4GB RAM,500GB,DOS",
                "65748",
                "12",
                "61520",
                "0",
                "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/385/2016/04/385_05138066843106823_360.jpg",
                "tv_1"));

        tvList.add(new Product(
                "HP",
                "HP DESKTOP 280( K8K31EA)CI3",
                "NMICRO TOWER/CI3(3.6GHZ),4GB RAM,500GB,DOS",
                "65748",
                "12",
                "61520",
                "0",
                "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/385/2016/04/385_05138066843106823_360.jpg",
                "tv_1"));

        productMap.put("Desktop", tvList);

        productlist = new ArrayList<Product>();

        // Vaccum Cleaner
        productlist
                .add(new Product(
                        "Mac Book ",
                        "New Pro 2016 Case",
                        "15\" New Pro 2016 Case, Hard Rubberized Protective Cover for 15.4 inch Macbook Crystal-Gray 15 NEW Pro 2016 (Model:A1707 on the bottom of laptop)",
                        "1345",
                        "10",
                        "1219",
                        "0",
                        "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/1761/2017/04/1761_05463398250476803_360.jpg",
                        "v_cleaner_1"));

        productlist
                .add(new Product(
                        "Mac Book ",
                        "New Pro 2016 Case",
                        "15\" New Pro 2016 Case, Hard Rubberized Protective Cover for 15.4 inch Macbook Crystal-Gray 15 NEW Pro 2016 (Model:A1707 on the bottom of laptop)",
                        "1345",
                        "10",
                        "1219",
                        "0",
                        "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/1761/2017/04/1761_05463398250476803_360.jpg",
                        "v_cleaner_1"));
        productlist
                .add(new Product(
                        "Mac Book ",
                        "New Pro 2016 Case",
                        "15\" New Pro 2016 Case, Hard Rubberized Protective Cover for 15.4 inch Macbook Crystal-Gray 15 NEW Pro 2016 (Model:A1707 on the bottom of laptop)",
                        "1345",
                        "10",
                        "1219",
                        "0",
                        "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/1761/2017/04/1761_05463398250476803_360.jpg",
                        "v_cleaner_1"));

        productlist
                .add(new Product(
                        "Mac Book ",
                        "New Pro 2016 Case",
                        "15\" New Pro 2016 Case, Hard Rubberized Protective Cover for 15.4 inch Macbook Crystal-Gray 15 NEW Pro 2016 (Model:A1707 on the bottom of laptop)",
                        "1345",
                        "10",
                        "1219",
                        "0",
                        "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/1761/2017/04/1761_05463398250476803_360.jpg",
                        "v_cleaner_1"));
        productlist
                .add(new Product(
                        "Mac Book ",
                        "New Pro 2016 Case",
                        "15\" New Pro 2016 Case, Hard Rubberized Protective Cover for 15.4 inch Macbook Crystal-Gray 15 NEW Pro 2016 (Model:A1707 on the bottom of laptop)",
                        "1345",
                        "10",
                        "1219",
                        "0",
                        "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/1761/2017/04/1761_05463398250476803_360.jpg",
                        "v_cleaner_1"));

        productMap.put("Peripherals and Accessories", productlist);


        CenterRepository.getCenterRepository().setMapOfProductsInCategory(productMap);

    }

    public void getAllFurnitures() {

        ConcurrentHashMap<String, ArrayList<Product>> productMap = new ConcurrentHashMap<String, ArrayList<Product>>();

        ArrayList<Product> productlist = new ArrayList<Product>();

        // Table
        productlist
                .add(new Product(
                        " Fashion one",
                        "Women's dress",
                        "Elegant Women White Dress Sleeveless Long Dress white s",
                        "2067",
                        "12",
                        "1529",
                        "0",
                        "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/964/2017/02/964_05409000148125568_360.png",
                        "table_1"));

        productlist
                .add(new Product(
                        " Fashion one",
                        "Women's dress",
                        "Elegant Women White Dress Sleeveless Long Dress white s",
                        "2067",
                        "12",
                        "1529",
                        "0",
                        "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/964/2017/02/964_05409000148125568_360.png",
                        "table_1"));

        productlist
                .add(new Product(
                        " Fashion one",
                        "Women's dress",
                        "Elegant Women White Dress Sleeveless Long Dress white s",
                        "2067",
                        "12",
                        "1529",
                        "0",
                        "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/964/2017/02/964_05409000148125568_360.png",
                        "table_1"));

        productlist
                .add(new Product(
                        " Fashion one",
                        "Women's dress",
                        "Elegant Women White Dress Sleeveless Long Dress white s",
                        "2067",
                        "12",
                        "1529",
                        "0",
                        "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/964/2017/02/964_05409000148125568_360.png",
                        "table_1"));

        productlist
                .add(new Product(
                        " Fashion one",
                        "Women's dress",
                        "Elegant Women White Dress Sleeveless Long Dress white s",
                        "2067",
                        "12",
                        "1529",
                        "0",
                        "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/964/2017/02/964_05409000148125568_360.png",
                        "table_1"));

        productlist
                .add(new Product(
                        " Fashion one",
                        "Women's dress",
                        "Elegant Women White Dress Sleeveless Long Dress white s",
                        "2067",
                        "12",
                        "1529",
                        "0",
                        "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/964/2017/02/964_05409000148125568_360.png",
                        "table_1"));
        productlist
                .add(new Product(
                        " Fashion one",
                        "Women's dress",
                        "Elegant Women White Dress Sleeveless Long Dress white s",
                        "2067",
                        "12",
                        "1529",
                        "0",
                        "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/964/2017/02/964_05409000148125568_360.png",
                        "table_1"));
        productlist
                .add(new Product(
                        " Fashion one",
                        "Women's dress",
                        "Elegant Women White Dress Sleeveless Long Dress white s",
                        "2067",
                        "12",
                        "1529",
                        "0",
                        "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/964/2017/02/964_05409000148125568_360.png",
                        "table_1"));

        productMap.put("Dresses", productlist);

        productlist = new ArrayList<Product>();

        // Chair
        productlist
                .add(new Product(
                        "Cincher Breast Lifter White",
                        "Women Body Shaper tight Vintage Corset Waist- ",
                        "Women Body Shaper tight Vintage Corset Waist- Cincher Breast Lifter White",
                        "2456",
                        "20",
                        "2100",
                        "0",
                        "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/6/2014/10/6_04669611258719624_360.jpg",
                        "chair_1"));

        productlist
                .add(new Product(
                        "Cincher Breast Lifter White",
                        "Women Body Shaper tight Vintage Corset Waist- ",
                        "Women Body Shaper tight Vintage Corset Waist- Cincher Breast Lifter White",
                        "2456",
                        "20",
                        "2100",
                        "0",
                        "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/6/2014/10/6_04669611258719624_360.jpg",
                        "chair_1"));

        productlist
                .add(new Product(
                        "Cincher Breast Lifter White",
                        "Women Body Shaper tight Vintage Corset Waist- ",
                        "Women Body Shaper tight Vintage Corset Waist- Cincher Breast Lifter White",
                        "2456",
                        "20",
                        "2100",
                        "0",
                        "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/6/2014/10/6_04669611258719624_360.jpg",
                        "chair_1"));

        productlist
                .add(new Product(
                        "Cincher Breast Lifter White",
                        "Women Body Shaper tight Vintage Corset Waist- ",
                        "Women Body Shaper tight Vintage Corset Waist- Cincher Breast Lifter White",
                        "2456",
                        "20",
                        "2100",
                        "0",
                        "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/6/2014/10/6_04669611258719624_360.jpg",
                        "chair_1"));
        productlist
                .add(new Product(
                        "Cincher Breast Lifter White",
                        "Women Body Shaper tight Vintage Corset Waist- ",
                        "Women Body Shaper tight Vintage Corset Waist- Cincher Breast Lifter White",
                        "2456",
                        "20",
                        "2100",
                        "0",
                        "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/6/2014/10/6_04669611258719624_360.jpg",
                        "chair_1"));

        productlist
                .add(new Product(
                        "Cincher Breast Lifter White",
                        "Women Body Shaper tight Vintage Corset Waist- ",
                        "Women Body Shaper tight Vintage Corset Waist- Cincher Breast Lifter White",
                        "2456",
                        "20",
                        "2100",
                        "0",
                        "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/6/2014/10/6_04669611258719624_360.jpg",
                        "chair_1"));

        productlist
                .add(new Product(
                        "Cincher Breast Lifter White",
                        "Women Body Shaper tight Vintage Corset Waist- ",
                        "Women Body Shaper tight Vintage Corset Waist- Cincher Breast Lifter White",
                        "2456",
                        "20",
                        "2100",
                        "0",
                        "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/6/2014/10/6_04669611258719624_360.jpg",
                        "chair_1"));

        productlist
                .add(new Product(
                        "Cincher Breast Lifter White",
                        "Women Body Shaper tight Vintage Corset Waist- ",
                        "Women Body Shaper tight Vintage Corset Waist- Cincher Breast Lifter White",
                        "2456",
                        "20",
                        "2100",
                        "0",
                        "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/6/2014/10/6_04669611258719624_360.jpg",
                        "chair_1"));

        productlist
                .add(new Product(
                        "Cincher Breast Lifter White",
                        "Women Body Shaper tight Vintage Corset Waist- ",
                        "Women Body Shaper tight Vintage Corset Waist- Cincher Breast Lifter White",
                        "2456",
                        "20",
                        "2100",
                        "0",
                        "https://d2lpfujvrf17tu.cloudfront.net/kenya/shop/store/goods/6/2014/10/6_04669611258719624_360.jpg",
                        "chair_1"));

        productMap.put("Lingerine", productlist);

        productlist = new ArrayList<Product>();

        // Chair
        productlist
                .add(new Product(
                        "China embroidered",
                        "This is a vintage dress that is very breathable. Loved by women in the former world.",
                        "The new China embroidered long qipao dress is a high-end luxury v-neck dress dress 910 M. This is a vintage dress that is very breathable. Loved by women in the former world.",
                        "2999",
                        "20",
                        "1999",
                        "0",
                        "http://img5a.flixcart.com/image/collapsible-wardrobe/h/h/g/best-quality-3-5-feet-foldable-storage-cabinet-almirah-shelf-400x400-imaees5fq7wbndak.jpeg",
                        "almirah_1"));

        productlist
                .add(new Product(
                        "China embroidered",
                        "This is a vintage dress that is very breathable. Loved by women in the former world.",
                        "The new China embroidered long qipao dress is a high-end luxury v-neck dress dress 910 M. This is a vintage dress that is very breathable. Loved by women in the former world.",
                        "2999",
                        "20",
                        "1999",
                        "0",
                        "http://img5a.flixcart.com/image/collapsible-wardrobe/h/h/g/best-quality-3-5-feet-foldable-storage-cabinet-almirah-shelf-400x400-imaees5fq7wbndak.jpeg",
                        "almirah_1"));

        productlist
                .add(new Product(
                        "China embroidered",
                        "This is a vintage dress that is very breathable. Loved by women in the former world.",
                        "The new China embroidered long qipao dress is a high-end luxury v-neck dress dress 910 M. This is a vintage dress that is very breathable. Loved by women in the former world.",
                        "2999",
                        "20",
                        "1999",
                        "0",
                        "http://img5a.flixcart.com/image/collapsible-wardrobe/h/h/g/best-quality-3-5-feet-foldable-storage-cabinet-almirah-shelf-400x400-imaees5fq7wbndak.jpeg",
                        "almirah_1"));

        productlist
                .add(new Product(
                        "China embroidered",
                        "This is a vintage dress that is very breathable. Loved by women in the former world.",
                        "The new China embroidered long qipao dress is a high-end luxury v-neck dress dress 910 M. This is a vintage dress that is very breathable. Loved by women in the former world.",
                        "2999",
                        "20",
                        "1999",
                        "0",
                        "http://img5a.flixcart.com/image/collapsible-wardrobe/h/h/g/best-quality-3-5-feet-foldable-storage-cabinet-almirah-shelf-400x400-imaees5fq7wbndak.jpeg",
                        "almirah_1"));
        productlist
                .add(new Product(
                        "China embroidered",
                        "This is a vintage dress that is very breathable. Loved by women in the former world.",
                        "The new China embroidered long qipao dress is a high-end luxury v-neck dress dress 910 M. This is a vintage dress that is very breathable. Loved by women in the former world.",
                        "2999",
                        "20",
                        "1999",
                        "0",
                        "http://img5a.flixcart.com/image/collapsible-wardrobe/h/h/g/best-quality-3-5-feet-foldable-storage-cabinet-almirah-shelf-400x400-imaees5fq7wbndak.jpeg",
                        "almirah_1"));

        productlist
                .add(new Product(
                        "China embroidered",
                        "This is a vintage dress that is very breathable. Loved by women in the former world.",
                        "The new China embroidered long qipao dress is a high-end luxury v-neck dress dress 910 M. This is a vintage dress that is very breathable. Loved by women in the former world.",
                        "2999",
                        "20",
                        "1999",
                        "0",
                        "http://img5a.flixcart.com/image/collapsible-wardrobe/h/h/g/best-quality-3-5-feet-foldable-storage-cabinet-almirah-shelf-400x400-imaees5fq7wbndak.jpeg",
                        "almirah_1"));

        productlist
                .add(new Product(
                        "China embroidered",
                        "This is a vintage dress that is very breathable. Loved by women in the former world.",
                        "The new China embroidered long qipao dress is a high-end luxury v-neck dress dress 910 M. This is a vintage dress that is very breathable. Loved by women in the former world.",
                        "2999",
                        "20",
                        "1999",
                        "0",
                        "http://img5a.flixcart.com/image/collapsible-wardrobe/h/h/g/best-quality-3-5-feet-foldable-storage-cabinet-almirah-shelf-400x400-imaees5fq7wbndak.jpeg",
                        "almirah_1"));

        productlist
                .add(new Product(
                        "China embroidered",
                        "This is a vintage dress that is very breathable. Loved by women in the former world.",
                        "The new China embroidered long qipao dress is a high-end luxury v-neck dress dress 910 M. This is a vintage dress that is very breathable. Loved by women in the former world.",
                        "2999",
                        "20",
                        "1999",
                        "0",
                        "http://img5a.flixcart.com/image/collapsible-wardrobe/h/h/g/best-quality-3-5-feet-foldable-storage-cabinet-almirah-shelf-400x400-imaees5fq7wbndak.jpeg",
                        "almirah_1"));



        productMap.put("Chinese Attire", productlist);


        CenterRepository.getCenterRepository().setMapOfProductsInCategory(productMap);

    }

    public void getAllProducts(int productCategory) {

        if (productCategory == 0) {

            getAllElectronics();
        } else {

            getAllFurnitures();

        }

    }

}
