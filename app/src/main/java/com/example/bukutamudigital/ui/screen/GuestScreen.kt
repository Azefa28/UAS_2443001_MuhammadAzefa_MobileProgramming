package com.example.bukutamudigital.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bukutamudigital.data.entity.Guest
import com.example.bukutamudigital.viewmodel.GuestViewModel
import com.example.bukutamudigital.viewmodel.PurposeViewModel

@Composable
fun GuestScreen(
    guestViewModel: GuestViewModel,
    purposeViewModel: PurposeViewModel
) {

    var nama by remember { mutableStateOf("") }
    var instansi by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }

    val guestList by guestViewModel.allGuest.collectAsState(initial = emptyList())

    var selectedGuest by remember { mutableStateOf<Guest?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            text = "👥 Data Tamu",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        // FORM INPUT
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {

            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                OutlinedTextField(
                    value = nama,
                    onValueChange = { nama = it },
                    label = { Text("Nama Tamu") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = instansi,
                    onValueChange = { instansi = it },
                    label = { Text("Instansi") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = noHp,
                    onValueChange = { noHp = it },
                    label = { Text("No HP") },
                    modifier = Modifier.fillMaxWidth()
                )

                Button(
                    onClick = {

                        if (
                            nama.isNotBlank() &&
                            instansi.isNotBlank() &&
                            email.isNotBlank() &&
                            noHp.isNotBlank()
                        ) {

                            if (selectedGuest == null) {

                                val guest = Guest(
                                    nama = nama,
                                    instansi = instansi,
                                    email = email,
                                    noHp = noHp
                                )

                                guestViewModel.insertGuest(guest)

                            } else {

                                val updated = selectedGuest!!.copy(
                                    nama = nama,
                                    instansi = instansi,
                                    email = email,
                                    noHp = noHp
                                )

                                guestViewModel.updateGuest(updated)
                            }

                            // Reset Form
                            nama = ""
                            instansi = ""
                            email = ""
                            noHp = ""
                            selectedGuest = null
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp)
                ) {
                    Text(
                        if (selectedGuest == null)
                            "SIMPAN"
                        else
                            "UPDATE"
                    )
                }
            }
        }

        // LIST DATA TAMU
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            items(guestList) { guest ->

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {

                        Text(
                            text = guest.nama,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Text("🏢 ${guest.instansi}")
                        Text("📧 ${guest.email}")
                        Text("📱 ${guest.noHp}")

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {

                            Button(
                                onClick = {
                                    selectedGuest = guest
                                    nama = guest.nama
                                    instansi = guest.instansi
                                    email = guest.email
                                    noHp = guest.noHp
                                },
                                modifier = Modifier.weight(1f)
                            ) {
                                Text("EDIT")
                            }

                            Button(
                                onClick = {
                                    guestViewModel.deleteGuest(guest)
                                },
                                modifier = Modifier.weight(1f),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Red
                                )
                            ) {
                                Text("HAPUS")
                            }
                        }
                    }
                }
            }
        }
    }
}


