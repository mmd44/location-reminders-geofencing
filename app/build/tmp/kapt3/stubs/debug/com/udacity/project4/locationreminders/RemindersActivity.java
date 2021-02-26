package com.udacity.project4.locationreminders;

import java.lang.System;

/**
 * The RemindersActivity that holds the reminders fragments
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \'2\u00020\u0001:\u0001\'B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0003J\"\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0012\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J+\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016\u00a2\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\nH\u0014J\b\u0010\"\u001a\u00020\nH\u0003J\b\u0010#\u001a\u00020\nH\u0002J\u0010\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020&H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006("}, d2 = {"Lcom/udacity/project4/locationreminders/RemindersActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/udacity/project4/databinding/ActivityRemindersBinding;", "getBinding", "()Lcom/udacity/project4/databinding/ActivityRemindersBinding;", "setBinding", "(Lcom/udacity/project4/databinding/ActivityRemindersBinding;)V", "checkDeviceLocationSettingsAndRequestPermissions", "", "resolve", "", "foregroundAndBackgroundLocationPermissionApproved", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onStart", "requestBackgroundLocationPermission", "requestForegroundLocationPermission", "showAlertDialog", "context", "Landroid/content/Context;", "Companion", "app_debug"})
public final class RemindersActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public com.udacity.project4.databinding.ActivityRemindersBinding binding;
    private static final java.lang.String TAG = "RemindersActivity";
    private static final int REQUEST_FOREGROUND_AND_BACKGROUND_PERMISSION_RESULT_CODE = 33;
    private static final int REQUEST_FOREGROUND_ONLY_PERMISSIONS_REQUEST_CODE = 34;
    private static final int REQUEST_TURN_DEVICE_LOCATION_ON = 29;
    private static final boolean runningQOrLater = false;
    public static final com.udacity.project4.locationreminders.RemindersActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.udacity.project4.databinding.ActivityRemindersBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.udacity.project4.databinding.ActivityRemindersBinding p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    private final void checkDeviceLocationSettingsAndRequestPermissions(boolean resolve) {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @android.annotation.TargetApi(value = 29)
    private final boolean foregroundAndBackgroundLocationPermissionApproved() {
        return false;
    }
    
    private final void requestForegroundLocationPermission() {
    }
    
    @android.annotation.TargetApi(value = 29)
    private final void requestBackgroundLocationPermission() {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    private final void showAlertDialog(android.content.Context context) {
    }
    
    public RemindersActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/udacity/project4/locationreminders/RemindersActivity$Companion;", "", "()V", "REQUEST_FOREGROUND_AND_BACKGROUND_PERMISSION_RESULT_CODE", "", "REQUEST_FOREGROUND_ONLY_PERMISSIONS_REQUEST_CODE", "REQUEST_TURN_DEVICE_LOCATION_ON", "TAG", "", "runningQOrLater", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}