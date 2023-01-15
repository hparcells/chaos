package com.themythichunter.chaos;

import com.themythichunter.chaos.events.*;
import com.themythichunter.chaos.events.explosivebeds.ExplosiveBedsEvent;
import com.themythichunter.chaos.events.firetrail.FireTrailEvent;
import com.themythichunter.chaos.events.foodpoisoning.FoodPoisoningEvent;
import com.themythichunter.chaos.events.slipperybuckets.SlipperyBucketsEvent;

public class Events {
    public static final ChaosEvent[] CHAOS_EVENTS = {
            new BedrockFeetEvent(),
            new HBannerEvent(),
            new BeefEvent(),
            new SkydiveEvent(),
            new ButterfingersEvent(),
            new TripEvent(),
            new SpeedEvent(),
            new JumpBoostEvent(),
            new FakeCreeperEvent(),
            new DiamondPickaxeEvent(),
            new BlindnessEvent(),
            new MiningFatigueEvent(),
            new HasteEvent(),
            new IgniteEvent(),
            new GardenerEvent(),
            new CreeperEvent(),
            new HalfHeartEvent(),
            new LightningEvent(),
            new AnvilEvent(),
            new ClearLagEvent(),
            new SkyLavaEvent(),
            new ZeroXpEvent(),
            new NiceXpEvent(),
            new HardEvent(),
            new TreeEvent(),
            new DiamondEvent(),
            new FireTrailEvent(),
            new ExplosiveBedsEvent(),
            new SlipperyBucketsEvent(),
            // new ChatKickEvent(),
            new FullHealEvent(),
            new FullHungerEvent(),
            new ZeroHungerEvent(),
            new FoodPoisoningEvent()
    };
}
