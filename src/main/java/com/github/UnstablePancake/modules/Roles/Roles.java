package com.github.UnstablePancake.modules.Roles;

import sx.blah.discord.handle.obj.Permissions;

import java.awt.*;
import java.util.EnumSet;

public enum Roles {

    // Main Roles
    admin("Administrator", new Color(78, 185, 110), RolePermissions.administrator),
    mod("Moderator", new Color(229, 76, 59), RolePermissions.moderator),
    regular("Regular", new Color(59, 151, 210), RolePermissions.regular),
    user("User", new Color(255, 255, 255), RolePermissions.user),
    guest("Guest", new Color(153, 170, 181), RolePermissions.guest),

    // Other Roles
    csgo("CSGO", new Color(153, 170, 181), RolePermissions.user);

    private final String NAME;
    private final Color COLOR;
    private final EnumSet<Permissions> PERMISSION;

    Roles(String n, Color c, EnumSet<Permissions> p){
        NAME = n;
        COLOR = c;
        PERMISSION = p;
    }

    public String getName(){
        return NAME;
    }

    public Color getColor(){
        return COLOR;
    }

    public EnumSet<Permissions> getPermission(){
        return PERMISSION;
    }
}
