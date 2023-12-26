package umc.study.converter;

import umc.study.domain.FoodCategory;
import umc.study.domain.mapping.FoodLike;

import java.util.List;
import java.util.stream.Collectors;

public class FoodLikeConverter {

    public static List<FoodLike> toMemberPreferList(List<FoodCategory> foodCategoryList){

        return foodCategoryList.stream()
                .map(foodCategory ->
                        FoodLike.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}