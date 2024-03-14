package com.company.thitracnghiem.web.screens.thisinh;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.screen.*;
import com.company.thitracnghiem.entity.ThiSinh;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;

import javax.inject.Inject;
import java.util.regex.Pattern;

@UiController("thitracnghiem_ThiSinh.edit")
@UiDescriptor("thi-sinh-edit.xml")
@EditedEntityContainer("thiSinhDc")
@LoadDataBeforeShow
public class ThiSinhEdit extends StandardEditor<ThiSinh> {
    @Inject
    private FileUploadField hinhAnh;

    @Inject
    private FileUploadingAPI fileUploadingAPI;

    @Inject
    private DataManager dataManager;

    @Inject
    private Notifications notifications;

    @Inject
    private UiComponents uiComponents;

    @Inject
    private Form form;

    @Subscribe("hinhAnh")
    public void onUploadFieldFileUploadSucceed(FileUploadField.FileUploadSucceedEvent event) {
        FileDescriptor fd = hinhAnh.getFileDescriptor();
        try {
            fileUploadingAPI.putFileIntoStorage(hinhAnh.getFileId(), fd);
        } catch (FileStorageException e) {
            throw new RuntimeException("Error saving file to FileStorage", e);
        }
        dataManager.commit(fd);
        if (fd != null) {
            Image image = uiComponents.create(Image.class);
            image.setWidth("100%");
            image.setHeight("100%");
            image.setSource(FileDescriptorResource.class).setFileDescriptor(fd);
            form.add(image);
        }
        notifications.create().withCaption("Uploaded file: " + hinhAnh.getFileName()).show();
    }
    @Subscribe("hinhAnh")
    public void onUploadFieldFileUploadError(UploadField.FileUploadErrorEvent event) {
        notifications.create()
                .withCaption("File upload error")
                .show();
    }

    @Inject
    private TextField<String> dnField;

    @Inject
    private PasswordField mkField;

    @Subscribe
    private void onInit(InitEvent event) {

        mkField.addValidator(value -> {
            if (value != null && !value.isEmpty()) {
                String pattern = "^[A-Z][a-zA-Z0-9]{0,49}[0-9]$";
                if (!Pattern.matches(pattern, value)) {
                    throw new ValidationException("The password must start with an uppercase letter and contain exactly one digit");
                }
            }
        });

        dnField.addValidator(value -> {
            if (value != null && !value.isEmpty()) {
                String pattern = "^[a-z0-9]+$";
                if (!Pattern.matches(pattern, value)) {
                    throw new ValidationException("Only numbers and character are allowed");
                }
            }
        });
    }

}