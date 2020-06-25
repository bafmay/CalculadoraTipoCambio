package com.retobcp.features.utils

import kotlinx.coroutines.*

suspend fun CoroutineScope.ui(f: suspend () -> Unit){
    withContext(Dispatchers.Main){ f.invoke()}
}

suspend fun CoroutineScope.io(f: suspend () -> Unit){
    withContext(Dispatchers.IO){ f.invoke()}
}

fun Any.ui(f:suspend () -> Unit){
    GlobalScope.launch(Dispatchers.Main){ f.invoke()}
}