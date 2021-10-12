package com.example.graduation_project.data.Register

class RegisterRepository(val dataSource: RegisterDataSource) {

    fun register(
        userEmail: String,
        password: String,
        userName: String,
        result: (Result<Unit>) -> Unit
    ) {
        return dataSource.register(userEmail, password, userName, result)
    }
}