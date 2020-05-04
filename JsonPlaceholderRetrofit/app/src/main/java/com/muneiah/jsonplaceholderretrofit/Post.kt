package com.muneiah.jsonplaceholderretrofit

import java.io.Serializable

data class Post(
	val id: Int? = null,
	val title: String? = null,
	val body: String? = null,
	val userId: Int? = null,
	val distric: Int? = null
)