package com.example.diexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.diexample.model.Smartphone
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var phone: Smartphone
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as MyApp).smartPhoneComponent.inject(this)
    }


    //  fun initDagger(){
    //        DaggerSmartPhoneComponent
//            .create(20)
//            .inject(this)
//        phone.makeCall()

    // }
    ////    val battery = Battery()
    ////    val serviceProvider = ServiceProvider()
    ////    val memoryCard = MemoryCard()
    ////    val simcard = Simcard(serviceProvider)
    ////    val iphoneX = Smartphone(
    ////        battery = battery,
    ////        memoryCard = memoryCard,
    ////        sim = simcard
    ////    )
    ////
    ////    val note20 = Smartphone(
    ////        Battery(),
    ////        Simcard(ServiceProvider()),
    ////        MemoryCard()
    ////    )
}
