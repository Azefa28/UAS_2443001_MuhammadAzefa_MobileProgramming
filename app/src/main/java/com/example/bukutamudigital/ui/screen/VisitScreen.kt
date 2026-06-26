package com.example.bukutamudigital.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bukutamudigital.data.entity.Visit
import com.example.bukutamudigital.data.entity.Guest
import com.example.bukutamudigital.data.entity.Purpose
import com.example.bukutamudigital.viewmodel.VisitViewModel
import com.example.bukutamudigital.viewmodel.GuestViewModel
import com.example.bukutamudigital.viewmodel.PurposeViewModel
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExposedDropdownMenuBox
//import androidx.compose.material3.ExposedDropdownMenu
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.ExperimentalMaterial3Api
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun VisitScreen(
    viewModel: VisitViewModel,
    guestViewModel: GuestViewModel,
    purposeViewModel: PurposeViewModel
) {

    // STATE
    var selectedGuest by remember { mutableStateOf<Guest?>(null) }
    var selectedPurpose by remember { mutableStateOf<Purpose?>(null) }

    var tanggal by remember { mutableStateOf("") }
    var jam by remember { mutableStateOf("") }

    var expandedGuest by remember { mutableStateOf(false) }
    var expandedPurpose by remember { mutableStateOf(false) }

    // DATA
    val guestList by guestViewModel.allGuest.collectAsState(initial = emptyList())
    val purposeList by purposeViewModel.allPurpose.collectAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(6.dp)
        ) {

            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {

                Text(
                    text = "📝 Form Kunjungan",
                    style = MaterialTheme.typography.headlineSmall
                )

                Text(
                    text = "Silakan isi data kunjungan tamu",
                    style = MaterialTheme.typography.bodyMedium
                )

                // ================= GUEST DROPDOWN =================

                ExposedDropdownMenuBox(
                    expanded = expandedGuest,
                    onExpandedChange = { expandedGuest = it }
                ) {
                    OutlinedTextField(
                        value = selectedGuest?.nama ?: "",
                        onValueChange = {},
                        readOnly = true,
                        label = { Text("Pilih Tamu") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .menuAnchor()
                    )

                    ExposedDropdownMenu(
                        expanded = expandedGuest,
                        onDismissRequest = { expandedGuest = false }
                    ) {
                        guestList.forEach { guest ->
                            DropdownMenuItem(
                                text = { Text(guest.nama) },
                                onClick = {
                                    selectedGuest = guest
                                    expandedGuest = false
                                }
                            )
                        }
                    }
                }

                // ================= PURPOSE DROPDOWN =================

                ExposedDropdownMenuBox(
                    expanded = expandedPurpose,
                    onExpandedChange = { expandedPurpose = it }
                ) {
                    OutlinedTextField(
                        value = selectedPurpose?.nama_keperluan ?: "",
                        onValueChange = {},
                        readOnly = true,
                        label = { Text("Pilih Keperluan") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .menuAnchor()
                    )

                    ExposedDropdownMenu(
                        expanded = expandedPurpose,
                        onDismissRequest = { expandedPurpose = false }
                    ) {
                        purposeList.forEach { purpose ->
                            DropdownMenuItem(
                                text = { Text(purpose.nama_keperluan) },
                                onClick = {
                                    selectedPurpose = purpose
                                    expandedPurpose = false
                                }
                            )
                        }
                    }
                }

                // ================= INPUT TANGGAL =================
                OutlinedTextField(
                    value = tanggal,
                    onValueChange = { tanggal = it },
                    label = { Text("Tanggal") },
                    modifier = Modifier.fillMaxWidth()
                )

                // ================= INPUT JAM =================
                OutlinedTextField(
                    value = jam,
                    onValueChange = { jam = it },
                    label = { Text("Jam") },
                    modifier = Modifier.fillMaxWidth()
                )

                // ================= BUTTON SIMPAN =================
                Button(
                    onClick = {

                        if (selectedGuest != null && selectedPurpose != null) {

                            val visit = Visit(
                                guestId = selectedGuest!!.id,
                                purposeId = selectedPurpose!!.id,
                                tanggal = tanggal,
                                jam = jam
                            )

                            viewModel.insertVisit(visit)

                            // reset
                            selectedGuest = null
                            selectedPurpose = null
                            tanggal = ""
                            jam = ""
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Text("SIMPAN KUNJUNGAN")
                }
            }
        }
    }
}