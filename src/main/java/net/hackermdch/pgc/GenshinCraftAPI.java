package net.hackermdch.pgc;

import net.hackermdch.genshincraft.element.Element;
import net.hackermdch.genshincraft.element.ElementDamageSource;
import net.minecraft.world.damagesource.DamageSource;

public class GenshinCraftAPI {
    public static DamageSource toElement(DamageSource origin, int type, float q) {
        q = Math.clamp(q, 0, 3);
        return new ElementDamageSource(origin, Element.fromType(type, q, Element.getDelta(q)));
    }

    public static DamageSource toElement(DamageSource origin, int type, float q, boolean a, boolean c, boolean cd, boolean k) {
        q = Math.clamp(q, 0, 3);
        return new ElementDamageSource(origin, Element.fromType(type, q, Element.getDelta(q))).setApply(a).setCritical(c).setCooldown(cd).setKnockback(k);
    }

    public static DamageSource setApply(DamageSource ds, boolean value) {
        return ds instanceof ElementDamageSource es ? es.setApply(value) : ds;
    }

    public static DamageSource setCritical(DamageSource ds, boolean value) {
        return ds instanceof ElementDamageSource es ? es.setCritical(value) : ds;
    }

    public static DamageSource setCooldown(DamageSource ds, boolean value) {
        return ds instanceof ElementDamageSource es ? es.setCooldown(value) : ds;
    }

    public static DamageSource setKnockback(DamageSource ds, boolean value) {
        return ds instanceof ElementDamageSource es ? es.setKnockback(value) : ds;
    }
}
