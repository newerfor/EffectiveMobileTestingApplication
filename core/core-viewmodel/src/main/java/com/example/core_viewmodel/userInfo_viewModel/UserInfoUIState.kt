package com.example.core_viewmodel.userInfo_viewModel

import com.example.core_domain.model.UserInfoDomainModel

interface UserInfoUIState {
    data object Loading : UserInfoUIState
    data object Empty : UserInfoUIState
    data class Success(val user: UserInfoDomainModel) : UserInfoUIState
    data class Error(val error: String) : UserInfoUIState
}