package com.company.thitracnghiem.core.role;

import com.company.thitracnghiem.entity.Khoa;
import com.company.thitracnghiem.entity.Lop;
import com.company.thitracnghiem.entity.ThiSinh;
import com.haulmont.cuba.security.app.role.AnnotatedRoleDefinition;
import com.haulmont.cuba.security.app.role.annotation.*;
import com.haulmont.cuba.security.entity.EntityOp;
import com.haulmont.cuba.security.entity.User;
import com.haulmont.cuba.security.role.EntityAttributePermissionsContainer;
import com.haulmont.cuba.security.role.EntityPermissionsContainer;
import com.haulmont.cuba.security.role.ScreenPermissionsContainer;
import com.haulmont.cuba.security.role.SpecificPermissionsContainer;

@Role(name = TeacherRole.NAME)
public class TeacherRole extends AnnotatedRoleDefinition {
    public final static String NAME = "Teacher";
    @EntityAttributeAccess(entityClass = ThiSinh.class, modify = "*")
    @Override
    public EntityAttributePermissionsContainer entityAttributePermissions() {
        return super.entityAttributePermissions();
    }

    @EntityAccess(entityClass = ThiSinh.class, operations = {EntityOp.CREATE, EntityOp.READ, EntityOp.UPDATE, EntityOp.DELETE})
    @Override
    public EntityPermissionsContainer entityPermissions() {
        return super.entityPermissions();
    }

    @ScreenAccess(screenIds = {
            "thitracnghiem_ThiSinh.browse",
            "thitracnghiem_ThiSinh.edit",
            "help",
            "aboutWindow",
            "settings"
    })
        @Override
        public ScreenPermissionsContainer screenPermissions() {
            return super.screenPermissions();
        }
}
