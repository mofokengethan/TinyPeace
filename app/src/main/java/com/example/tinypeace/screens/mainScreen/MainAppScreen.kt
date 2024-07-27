package com.example.tinypeace.screens.mainScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Airlines
import androidx.compose.material.icons.outlined.Contacts
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Newspaper
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBarDefaults.containerColor
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults.pinnedScrollBehavior
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tinypeace.screens.mainScreen.data.MainAppScreenType
import com.example.tinypeace.screens.mainScreen.data.MainAppScreenViewModel
import com.example.tinypeace.screens.viewFive.ViewFive
import com.example.tinypeace.screens.viewFour.ViewFour
import com.example.tinypeace.screens.viewOne.ViewOne
import com.example.tinypeace.screens.viewThree.ViewThree
import com.example.tinypeace.screens.viewTwo.ViewTwo


@Composable
fun MainAppScreen(vm: MainAppScreenViewModel = viewModel()) {
    Box(modifier = Modifier
        .fillMaxSize(1f)
    ) {
        Scaffold(
            bottomBar = {
                NavigationBar(
                    modifier = Modifier,
                    containerColor = containerColor,
                    contentColor = contentColorFor(containerColor),
                    tonalElevation = NavigationBarDefaults.Elevation,
                    windowInsets = NavigationBarDefaults.windowInsets,
                ) {
                    NavigationBarItem(selected = false, onClick = {
                        vm.changeView(vm.screenType.value, MainAppScreenType.One)
                    }, icon = { BadgedBox(badge = {}) {
                        Icon(imageVector = Icons.Outlined.Home, contentDescription = Icons.Outlined.Newspaper.name)
                    }
                    })
                    NavigationBarItem(selected = false, onClick = {
                        vm.changeView(vm.screenType.value, MainAppScreenType.Two)

                    }, icon = { BadgedBox(badge = {}) {
                        Icon(imageVector = Icons.Outlined.Contacts, contentDescription = Icons.Outlined.Contacts.name)
                    }
                    })
                    NavigationBarItem(selected = false, onClick = {
                        vm.changeView(vm.screenType.value, MainAppScreenType.Three)
                    }, icon = { BadgedBox(badge = {}) {
                        Icon(imageVector = Icons.Outlined.AddCircle, contentDescription = Icons.Outlined.AddCircle.name)
                    }
                    })
                    NavigationBarItem(selected = false, onClick = {
                        vm.changeView(vm.screenType.value, MainAppScreenType.Four)
                    }, icon = { BadgedBox(badge = {}) {
                        Icon(imageVector = Icons.Outlined.Airlines, contentDescription = Icons.Outlined.Airlines.name)
                    }
                    })
                    NavigationBarItem(selected = false, onClick = {
                        vm.changeView(vm.screenType.value, MainAppScreenType.Five)
                    }, icon = { BadgedBox(badge = {}) {
                        Icon(imageVector = Icons.Outlined.PersonOutline, contentDescription = Icons.Outlined.PersonOutline.name)
                    }
                    })
                }
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
            ) {
                when (vm.screenType.collectAsState().value) {
                    MainAppScreenType.One -> ViewOne()
                    MainAppScreenType.Two -> ViewTwo()
                    MainAppScreenType.Three -> ViewThree()
                    MainAppScreenType.Four -> ViewFour()
                    MainAppScreenType.Five -> ViewFive()
                }
            }
        }
    }
}