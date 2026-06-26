package com.example.bukutamudigital.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bukutamudigital.data.entity.Purpose
import com.example.bukutamudigital.viewmodel.PurposeViewModel

@Composable
fun PurposeScreen(
    purposeViewModel: PurposeViewModel
) {

    var namaTujuan by remember { mutableStateOf("") }

    val purposeList by purposeViewModel.allPurpose
        .collectAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            text = "🎯 Data Keperluan",
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
                    value = namaTujuan,
                    onValueChange = { namaTujuan = it },
                    label = { Text("Nama Keperluan") },
                    modifier = Modifier.fillMaxWidth()
                )

                Button(
                    onClick = {

                        if (namaTujuan.isNotBlank()) {

                            val purpose = Purpose(
                                nama_keperluan = namaTujuan
                            )

                            purposeViewModel.insertPurpose(purpose)

                            namaTujuan = ""
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp)
                ) {
                    Text("SIMPAN")
                }
            }
        }

        // LIST DATA
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            items(purposeList) { purpose ->

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {

                        Text(
                            text = purpose.nama_keperluan,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Button(
                            onClick = {
                                purposeViewModel.deletePurpose(purpose)
                            },
                            modifier = Modifier.fillMaxWidth(),
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
