package com.example.armen.mynoutbook.providers;

import android.content.Context;

import com.example.armen.mynoutbook.CategoryEnum.Category;
import com.example.armen.mynoutbook.R;
import com.example.armen.mynoutbook.models.ProductModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrProvider {
    public static int position;
    public static List<ProductModel> prList = new ArrayList<>();

    public static List<ProductModel> getPrList(Context context) {
        if (!prList.isEmpty()) {
            prList.clear();
        }

        prList.add(new ProductModel(context.getResources().getStringArray(R.array.arr_predator_img), context.getString(R.string.predator_video), context.getString(R.string.title_predator), Category.PREDATOR, context.getString(R.string.price_predator), context.getString(R.string.predator_text), false, false, 0));
        prList.add(new ProductModel(context.getResources().getStringArray(R.array.arr_gs_img), context.getString(R.string.msi_video), context.getString(R.string.title_msi), Category.MSI, context.getString(R.string.price_msi), context.getString(R.string.msi_gs63_text), false, false, 0));
        prList.add(new ProductModel(context.getResources().getStringArray(R.array.arr_zephyrus_img), context.getString(R.string.asus_video), context.getString(R.string.title_asus), Category.ROG, context.getString(R.string.price_asus), context.getString(R.string.asus_text), false, false, 0));
        prList.add(new ProductModel(context.getResources().getStringArray(R.array.arr_gig_img), context.getString(R.string.gig_video), context.getString(R.string.title_gig), Category.GIG, context.getString(R.string.price_gig), context.getString(R.string.gigabyte_text), false, false, 0));
        prList.add(new ProductModel(context.getResources().getStringArray(R.array.arr_Apple_img), context.getString(R.string.apple_video), context.getString(R.string.title_apple), Category.APPLE, context.getString(R.string.price_apple), context.getString(R.string.apple_text), false, false, 0));
        prList.add(new ProductModel(context.getResources().getStringArray(R.array.arr_Razer_img), context.getString(R.string.razer_video), context.getString(R.string.title_razer), Category.RAZER, context.getString(R.string.price_razer), context.getString(R.string.razer_text), false, false, 0));
        Collections.shuffle(prList);
        return prList;
    }

    public static List<ProductModel> getListByCategory(Enum<Category> category) {
        List<ProductModel> listByCategory = new ArrayList<>();
        for (int i = 0; i < prList.size(); i++) {
            if (prList.get(i).getCategory().equals(category)) {
                listByCategory.add(prList.get(i));
            }
        }
        return listByCategory;
    }

    public static List<ProductModel> getListByFavorite() {
        List<ProductModel> favoriteList = new ArrayList<>();
        for (int i = 0; i < prList.size(); i++) {
            if (prList.get(i).isFavorite()) {
                favoriteList.add(prList.get(i));
            }
        }
        return favoriteList;
    }

    public static List<ProductModel> getListByCard() {
        List<ProductModel> cardList = new ArrayList<>();
        for (int i = 0; i < prList.size(); i++) {
            if (prList.get(i).isCardBy()) {
                cardList.add(prList.get(i));
            }
        }
        return cardList;
    }

    public static ProductModel getIntPosition() {
        return prList.get(position);
    }
}
