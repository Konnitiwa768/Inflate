package com.sakalti.inflate;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class System {

    // 金と鉄で倍率を調整するメソッド
    public static ActionResult adjustMultiplier(PlayerEntity player, ItemStack stack, Hand hand) {
        if (player.world.isClient) {
            return ActionResult.PASS;
        }

        // アイテムが金か鉄の場合
        if (stack.getItem() == Items.GOLD_INGOT || stack.getItem() == Items.IRON_INGOT) {
            // スニークして右クリックした場合、アイテム1つ消費
            if (player.isSneaking()) {
                stack.decrement(1);

                // 倍率を+0.05
                Inflate.playerHealthMultiplier += Inflate.multiplierIncrease;
                Inflate.playerAttackMultiplier += Inflate.multiplierIncrease;

                player.sendMessage("倍率が増加しました！現在の倍率: HP=" + Inflate.playerHealthMultiplier + " 攻撃力=" + Inflate.playerAttackMultiplier);
            }
        }

        return ActionResult.SUCCESS;
    }
}
