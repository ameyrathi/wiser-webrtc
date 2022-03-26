package com.robin.wiser_wrtc

class User(val id: Int, val name: String, val displayPictureUrl: String) {
    companion object {
        val dummy_user_1 = User(1, "Jane", "https://images.unsplash.com/photo-1566616213894-2d4e1baee5d8?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2071&q=80")
        val dummy_user_2 = User(2, "May", "https://images.unsplash.com/photo-1519975258993-60b42d1c2ee2?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80")
        val dummy_user_3 = User(3, "Joseph", "https://images.unsplash.com/photo-1584984793889-6ac1bbe1a2b3?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1780&q=80")
    }
}