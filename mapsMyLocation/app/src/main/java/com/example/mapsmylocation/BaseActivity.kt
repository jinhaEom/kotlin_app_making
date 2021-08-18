package com.example.mapsmylocation

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

abstract class BaseActivity : AppCompatActivity() {
    abstract fun permissionGranted(RequestCode: Int)
    abstract fun permissionDenied(RequestCode: Int)

    fun requirePermissions(permissions: Array<String>, requestCode: Int) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            permissionGranted(requestCode)
        } else {
            val isAllPermissionsGranted = permissions.all {
                checkSelfPermission(it) == PackageManager.PERMISSION_GRANTED

            }
            if(isAllPermissionsGranted){
                permissionGranted(requestCode)
            }else{
                ActivityCompat.requestPermissions(this,permissions,requestCode)
            }
        }
    }
//사용자가 권한을 승인하거나 거부한 다음에 호출되는 메서드
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if(grantResults.all{it==PackageManager.PERMISSION_GRANTED}){
            permissionGranted(requestCode)
        }else{
            permissionDenied(requestCode)
        }
    }
}

