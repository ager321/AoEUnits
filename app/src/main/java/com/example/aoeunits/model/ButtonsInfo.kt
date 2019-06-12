package com.example.aoeunits.model

import com.example.aoeunits.view.MainActivity
import dagger.Component
import javax.inject.Inject


class ButtonsInfo @Inject constructor(){
    val list_button_info = "List"
    val find_button_info = "Find"
}

@Component
interface ButtonInfoComponent {
    fun inject(app: MainActivity)
}