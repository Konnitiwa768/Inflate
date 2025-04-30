package com.sakalti.inflate;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class Inflate {

    // プレイヤーの倍率
    public static double playerHealthMultiplier = 8.0;
    public static double playerAttackMultiplier = 6.0;
    public static double playerAttackConstantMultiplier = 7.0;
    public static double multiplierIncrease = 0.05;

    // プレイヤーHP、攻撃力を変更するメソッド
    public static void inflatePlayerStats(PlayerEntity player) {
        player.setHealth(player.getMaxHealth() * playerHealthMultiplier);
    }

    // モブHPを10倍にするメソッド
    public static void inflateMobHealth(LivingEntity entity) {
        double inflatedHealth = entity.getMaxHealth() * 10.0;
        entity.setHealth((float) inflatedHealth);
    }

    // プレイヤーの攻撃に倍率を掛けるメソッド
    public static double getModifiedAttackDamage(double baseDamage) {
        return baseDamage * playerAttackMultiplier * playerAttackConstantMultiplier;
    }
}
