package com.example.aula_0805_e_1505

import AuthService
import MusicaService
import RetrofitConfig
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<MusicaService> {
        RetrofitConfig
            .instance
            .create(MusicaService::class.java)
    }

    single<AuthService> {
        RetrofitConfig.instance.create(AuthService::class.java)
    }

//    val response = LoginResponse(token = "02ioejiowkajnikejwj")

    single<AuthRepository>{
        AuthRepository(get())
    }

    single<MusicaRepository> {
//        MusicaRepositoryImpl(get())
        MusicaRepositoryMockImpl()
    }

    viewModel<MainViewModel> {
        MainViewModel(get(), get())
    }
}