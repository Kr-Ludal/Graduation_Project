package com.example.graduation_project.ui.Write

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.graduation_project.data.Write.WriteDataSource
import com.example.graduation_project.data.Write.WriteRepository
import java.lang.IllegalArgumentException

class WriteViewModelFactory :ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WriteViewModel::class.java)) {
            return WriteViewModel(
                writeRepository = WriteRepository(dataSource = WriteDataSource())
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

