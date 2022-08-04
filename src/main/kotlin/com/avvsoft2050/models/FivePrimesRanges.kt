package com.avvsoft2050.models

import kotlinx.serialization.Serializable

@Serializable
data class FivePrimesRanges(val randomSixPrimesLists: MutableList<MutableList<Int>>)