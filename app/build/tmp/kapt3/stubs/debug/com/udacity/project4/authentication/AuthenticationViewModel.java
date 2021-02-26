package com.udacity.project4.authentication;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2 = {"Lcom/udacity/project4/authentication/AuthenticationViewModel;", "Lcom/udacity/project4/base/BaseViewModel;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "getApp", "()Landroid/app/Application;", "authenticationState", "Landroidx/lifecycle/LiveData;", "Lcom/udacity/project4/authentication/AuthenticationViewModel$AuthenticationState;", "getAuthenticationState", "()Landroidx/lifecycle/LiveData;", "AuthenticationState", "app_debug"})
public final class AuthenticationViewModel extends com.udacity.project4.base.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.udacity.project4.authentication.AuthenticationViewModel.AuthenticationState> authenticationState = null;
    @org.jetbrains.annotations.NotNull()
    private final android.app.Application app = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.udacity.project4.authentication.AuthenticationViewModel.AuthenticationState> getAuthenticationState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Application getApp() {
        return null;
    }
    
    public AuthenticationViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/udacity/project4/authentication/AuthenticationViewModel$AuthenticationState;", "", "(Ljava/lang/String;I)V", "AUTHENTICATED", "UNAUTHENTICATED", "INVALID_AUTHENTICATION", "app_debug"})
    public static enum AuthenticationState {
        /*public static final*/ AUTHENTICATED /* = new AUTHENTICATED() */,
        /*public static final*/ UNAUTHENTICATED /* = new UNAUTHENTICATED() */,
        /*public static final*/ INVALID_AUTHENTICATION /* = new INVALID_AUTHENTICATION() */;
        
        AuthenticationState() {
        }
    }
}