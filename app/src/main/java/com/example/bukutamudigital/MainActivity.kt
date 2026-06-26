package com.example.bukutamudigital

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.bukutamudigital.data.database.AppDatabase
import com.example.bukutamudigital.data.repository.GuestRepository
import com.example.bukutamudigital.ui.screen.GuestScreen
import com.example.bukutamudigital.ui.theme.BukuTamuDigitalTheme
import com.example.bukutamudigital.viewmodel.GuestViewModel
import com.example.bukutamudigital.viewmodel.GuestViewModelFactory
import com.example.bukutamudigital.repository.PurposeRepository
import com.example.bukutamudigital.data.repository.VisitRepository
import com.example.bukutamudigital.ui.screen.PurposeScreen
import com.example.bukutamudigital.ui.screen.VisitReportScreen
import com.example.bukutamudigital.ui.screen.VisitScreen
import com.example.bukutamudigital.viewmodel.PurposeViewModel
import com.example.bukutamudigital.viewmodel.PurposeViewModelFactory
import com.example.bukutamudigital.viewmodel.VisitViewModel
import com.example.bukutamudigital.viewmodel.VisitViewModelFactory
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bukutamudigital.ui.screen.Screen
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.bukutamudigital.ui.screen.BottomBar

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "bukutamu_db"
        ).fallbackToDestructiveMigration().build()

        val guestRepository = GuestRepository(db.guestDao())
        val purposeRepository = PurposeRepository(db.purposeDao())
        val visitRepository = VisitRepository(db.visitDao())

        val guestViewModel = ViewModelProvider(
            this,
            GuestViewModelFactory(guestRepository)
        )[GuestViewModel::class.java]

        val purposeViewModel = ViewModelProvider(
            this,
            PurposeViewModelFactory(purposeRepository)
        )[PurposeViewModel::class.java]

        val visitViewModel = ViewModelProvider(
            this,
            VisitViewModelFactory(visitRepository)
        )[VisitViewModel::class.java]


        setContent {
            BukuTamuDigitalTheme {

                val navController = rememberNavController()

                Column(
                    modifier = Modifier.fillMaxSize()
                ) {

                    NavHost(
                        navController = navController,
                        startDestination = Screen.Guest.route,
                        modifier = Modifier.weight(1f)
                    ) {

                        composable(Screen.Guest.route) {
                            GuestScreen(
                                guestViewModel = guestViewModel,
                                purposeViewModel = purposeViewModel
                            )
                        }

                        composable(Screen.Purpose.route) {
                            PurposeScreen(purposeViewModel)
                        }

                        composable(Screen.Visit.route) {
                            VisitScreen(
                                viewModel = visitViewModel,
                                guestViewModel = guestViewModel,
                                purposeViewModel = purposeViewModel
                            )
                        }

                        composable(Screen.Report.route) {
                            VisitReportScreen(visitViewModel)
                        }
                    }

                    BottomBar(navController)
                }
            }

        }
    }
}