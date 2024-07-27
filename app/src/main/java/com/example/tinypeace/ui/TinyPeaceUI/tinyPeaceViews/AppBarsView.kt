package com.example.tinypeace.TinyPeaceUI.tinyPeaceViews

import androidx.annotation.Nullable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material.icons.outlined.Cookie
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.BottomAppBarDefaults.containerColor
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.tinypeace.TinyPeaceUI.tinyPeaceComposables.TP_Button
import com.example.tinypeace.TinyPeaceUI.tinyPeaceComposables.TP_Icon
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.enums.TinyPeaceButtonType
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceBasicIconModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.buttonData.models.TinyPeaceButtonModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.iconData.IconModel
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.iconData.IconViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TP_AppBar(
    type: com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType,
    model: com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.model.AppBarModel,
    scrollBehavior: TopAppBarScrollBehavior
) {
    when (type) {
        com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType.TopAppBar -> {
            TopAppBar(
                title = { Text("Small Top App Bar", style = MaterialTheme.typography.labelLarge) },
                modifier = model.modifier,
                navigationIcon = {
                    model.hasNavigationIcon?.let { viewModel: IconViewModel ->
                        TP_Icon(viewModel = viewModel)
                    }
                },
                actions = {
                    model.hasActions?.first?.let { viewModel: IconViewModel ->
                        TP_Icon(viewModel = viewModel)
                    }
                    model.hasActions?.second?.let { viewModel: IconViewModel ->
                        TP_Icon(viewModel = viewModel)
                    }
                    model.hasMenuOption?.let { viewModel: IconViewModel ->
                        TP_Icon(viewModel = IconViewModel(
                            model = IconModel(
                                showIcon = viewModel.icon.showIcon,
                                isClickable = viewModel.icon.isClickable,
                                imageVector = Icons.Default.MoreVert,
                                modifier = viewModel.icon.modifier
                            )
                        )
                        )
                    }
                },
                windowInsets = TopAppBarDefaults.windowInsets,
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                scrollBehavior = scrollBehavior
            )
        }
        com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType.CenterAlignedTopAppBar -> {
            CenterAlignedTopAppBar(
                title = { Text("Small Top App Bar", style = MaterialTheme.typography.labelLarge) },
                modifier = model.modifier,
                navigationIcon = {
                    model.hasNavigationIcon?.let { viewModel: IconViewModel ->
                        TP_Icon(viewModel = viewModel)
                    }
                },
                actions = {
                    model.hasActions?.first?.let { viewModel: IconViewModel ->
                        TP_Icon(viewModel = viewModel)
                    }
                    model.hasActions?.second?.let { viewModel: IconViewModel ->
                        TP_Icon(viewModel = viewModel)
                    }
                    model.hasMenuOption?.let { viewModel: IconViewModel ->
                        TP_Icon(viewModel = IconViewModel(
                            model = IconModel(
                                showIcon = viewModel.icon.showIcon,
                                isClickable = viewModel.icon.isClickable,
                                imageVector = Icons.Default.MoreVert,
                                modifier = viewModel.icon.modifier
                            ))
                        )
                    }
                },
                windowInsets = TopAppBarDefaults.windowInsets,
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                scrollBehavior = scrollBehavior
            )
        }
        com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType.MediumTopAppBar -> {
            MediumTopAppBar(
                title = { Text("Small Top App Bar", style = MaterialTheme.typography.labelLarge) },
                modifier = model.modifier,
                navigationIcon = {
                    model.hasNavigationIcon?.let { viewModel: IconViewModel ->
                        TP_Icon(viewModel = viewModel)
                    }
                },
                actions = {
                    model.hasActions?.first?.let { viewModel: IconViewModel ->
                        TP_Icon(viewModel = viewModel)
                    }
                    model.hasActions?.second?.let { viewModel: IconViewModel ->
                        TP_Icon(viewModel = viewModel)
                    }
                    model.hasMenuOption?.let { viewModel: IconViewModel ->
                        TP_Icon(viewModel = IconViewModel(
                            model = IconModel(
                                showIcon = viewModel.icon.showIcon,
                                isClickable = viewModel.icon.isClickable,
                                imageVector = Icons.Default.MoreVert,
                                modifier = viewModel.icon.modifier
                            ))
                        )
                    }
                },
                windowInsets = TopAppBarDefaults.windowInsets,
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                scrollBehavior = scrollBehavior
            )
        }
        com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType.LargeTopAppBar -> {
            LargeTopAppBar(
                title = { Text("Large Top App Bar", style = MaterialTheme.typography.bodySmall) },
                modifier = model.modifier,
                navigationIcon = {
                    model.hasNavigationIcon?.let { viewModel: IconViewModel ->
                        TP_Icon(viewModel = viewModel)
                    }
                },
                actions = {
                    model.hasActions?.first?.let { viewModel: IconViewModel ->
                        TP_Icon(viewModel = viewModel)
                    }
                    model.hasActions?.second?.let { viewModel: IconViewModel ->
                        TP_Icon(viewModel = viewModel)
                    }
                    model.hasMenuOption?.let { viewModel: IconViewModel ->
                        TP_Icon(viewModel = IconViewModel(
                            model = IconModel(
                                showIcon = viewModel.icon.showIcon,
                                isClickable = viewModel.icon.isClickable,
                                imageVector = Icons.Default.MoreVert,
                                modifier = viewModel.icon.modifier
                            ))
                        )
                    }
                },
                windowInsets = TopAppBarDefaults.windowInsets,
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                scrollBehavior = scrollBehavior
            )
        }
        com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType.BottomAppBar -> {
            BottomAppBar(
                actions = {
                    model.bottomBarBadges?.let { badges: List<IconViewModel> ->
                        badges.forEach { _ ->
                            var index = 0
                            Row {
                                TP_Icon(badges[index])
                            }
                            index += 1
                        }
                    }
                },
                modifier = Modifier,
                floatingActionButton = {
                    model.hasFloatingAction?.let { viewModel: IconViewModel ->
                        if (viewModel.icon.showIcon) {
                            TP_Button(
                                tinyPeaceButtonModel = TinyPeaceButtonModel<Nullable>(
                                    action = {
                                        println("Floating Action Button 3")
                                    },
                                    buttonType = TinyPeaceButtonType.FloatingActionButton,
                                    modifier = Modifier
                                        .padding(8.dp),
                                    enable = true,
                                    text = null,
                                    basicIcon = TinyPeaceBasicIconModel(
                                        imageVector = viewModel.icon.imageVector,
                                        description = viewModel.icon.imageVector.name,
                                        modifier = viewModel.icon.modifier
                                            .padding(8.dp)
                                    ),
                                    iconButton = null,
                                    segmentedButton = null,
                                    onPressInteraction = null
                                )
                            )
                        }
                    }
                },
                containerColor = containerColor,
                contentColor = contentColorFor(containerColor),
                tonalElevation = BottomAppBarDefaults.ContainerElevation,
                contentPadding = BottomAppBarDefaults.ContentPadding,
                windowInsets = BottomAppBarDefaults.windowInsets
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TP_AppBarView(
    appBarViewModel: com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType,
    content: @Composable (padding: PaddingValues) -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    // val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    Scaffold(
        // modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            when (appBarViewModel) {
                com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType.TopAppBar -> {
                    TP_AppBar(
                        type = com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType.TopAppBar,
                        scrollBehavior = scrollBehavior,
                        model = com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.model.AppBarModel(
                            hasNavigationIcon = IconViewModel(
                                IconModel(
                                    showIcon = true,
                                    isClickable = Pair(false, null),
                                    imageVector = Icons.Outlined.ArrowBackIosNew,
                                    modifier = Modifier
                                )
                            ),
                            hasActions = Pair(
                                first = IconViewModel(
                                    IconModel(
                                        showIcon = true,
                                        isClickable = Pair(false, null),
                                        imageVector = Icons.Outlined.AddCircle,
                                        modifier = Modifier
                                    )
                                ),
                                second = IconViewModel(
                                    IconModel(
                                        showIcon = true,
                                        isClickable = Pair(false, null),
                                        imageVector = Icons.Outlined.Edit,
                                        modifier = Modifier
                                    )
                                )
                            ),
                            hasMenuOption = IconViewModel(
                                IconModel(
                                    showIcon = true,
                                    isClickable = Pair(false, null),
                                    imageVector = Icons.Outlined.Cookie,
                                    modifier = Modifier
                                )
                            ),
                            bottomBarBadges = null,
                            hasFloatingAction = null,
                            modifier = Modifier
                        )
                    )
                }
                com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType.CenterAlignedTopAppBar -> {
                    TP_AppBar(
                        type = com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType.CenterAlignedTopAppBar,
                        scrollBehavior = scrollBehavior,
                        model = com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.model.AppBarModel(
                            hasNavigationIcon = IconViewModel(
                                IconModel(
                                    showIcon = true,
                                    isClickable = Pair(false, null),
                                    imageVector = Icons.Outlined.ArrowBackIosNew,
                                    modifier = Modifier
                                )
                            ),
                            hasActions = Pair(
                                first = IconViewModel(
                                    IconModel(
                                        showIcon = true,
                                        isClickable = Pair(false, null),
                                        imageVector = Icons.Outlined.AddCircle,
                                        modifier = Modifier
                                    )
                                ),
                                second = IconViewModel(
                                    IconModel(
                                        showIcon = true,
                                        isClickable = Pair(false, null),
                                        imageVector = Icons.Outlined.Edit,
                                        modifier = Modifier
                                    )
                                )
                            ),
                            hasMenuOption = IconViewModel(
                                IconModel(
                                    showIcon = true,
                                    isClickable = Pair(false, null),
                                    imageVector = Icons.Outlined.Cookie,
                                    modifier = Modifier
                                )
                            ),
                            bottomBarBadges = null,
                            hasFloatingAction = null,
                            modifier = Modifier
                        )
                    )
                }
                com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType.MediumTopAppBar -> {
                    TP_AppBar(
                        type = com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType.MediumTopAppBar,
                        scrollBehavior = scrollBehavior,
                        model = com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.model.AppBarModel(
                            hasNavigationIcon = IconViewModel(
                                IconModel(
                                    showIcon = true,
                                    isClickable = Pair(false, null),
                                    imageVector = Icons.Outlined.ArrowBackIosNew,
                                    modifier = Modifier
                                )
                            ),
                            hasActions = Pair(
                                first = IconViewModel(
                                    IconModel(
                                        showIcon = true,
                                        isClickable = Pair(false, null),
                                        imageVector = Icons.Outlined.AddCircle,
                                        modifier = Modifier
                                    )
                                ),
                                second = IconViewModel(
                                    IconModel(
                                        showIcon = true,
                                        isClickable = Pair(false, null),
                                        imageVector = Icons.Outlined.Edit,
                                        modifier = Modifier
                                    )
                                )
                            ),
                            hasMenuOption = IconViewModel(
                                IconModel(
                                    showIcon = true,
                                    isClickable = Pair(false, null),
                                    imageVector = Icons.Outlined.Cookie,
                                    modifier = Modifier
                                )
                            ),
                            bottomBarBadges = null,
                            hasFloatingAction = null,
                            modifier = Modifier
                        )
                    )
                }
                com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType.LargeTopAppBar -> {
                    TP_AppBar(
                        type = com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType.LargeTopAppBar,
                        scrollBehavior = scrollBehavior,
                        model = com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.model.AppBarModel(
                            hasNavigationIcon = IconViewModel(
                                IconModel(
                                    showIcon = true,
                                    isClickable = Pair(false, null),
                                    imageVector = Icons.Outlined.ArrowBackIosNew,
                                    modifier = Modifier
                                )
                            ),
                            hasActions = Pair(
                                first = IconViewModel(
                                    IconModel(
                                        showIcon = true,
                                        isClickable = Pair(false, null),
                                        imageVector = Icons.Outlined.AddCircle,
                                        modifier = Modifier
                                    )
                                ),
                                second = IconViewModel(
                                    IconModel(
                                        showIcon = true,
                                        isClickable = Pair(false, null),
                                        imageVector = Icons.Outlined.Edit,
                                        modifier = Modifier
                                    )
                                )
                            ),
                            hasMenuOption = IconViewModel(
                                IconModel(
                                    showIcon = true,
                                    isClickable = Pair(false, null),
                                    imageVector = Icons.Outlined.Cookie,
                                    modifier = Modifier
                                )
                            ),
                            bottomBarBadges = null,
                            hasFloatingAction = null,
                            modifier = Modifier
                        )
                    )
                }
                com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType.BottomAppBar -> Unit
            }

        },
        bottomBar = {
            when (appBarViewModel) {
                com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType.TopAppBar, com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType.CenterAlignedTopAppBar,
                com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType.MediumTopAppBar, com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType.LargeTopAppBar -> Unit
                com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType.BottomAppBar -> {
                    TP_AppBar(
                        type = com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType.BottomAppBar,
                        scrollBehavior = scrollBehavior,
                        model = com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.model.AppBarModel(
                            hasNavigationIcon = null,
                            hasActions = null,
                            hasMenuOption = null,
                            bottomBarBadges = listOf(
                                IconViewModel(
                                    IconModel(
                                        showIcon = true,
                                        isClickable = Pair(false, null),
                                        imageVector = Icons.Outlined.Cookie,
                                        modifier = Modifier.padding(vertical = 12.dp)
                                    )
                                ),
                                IconViewModel(
                                    IconModel(
                                        showIcon = true,
                                        isClickable = Pair(false, null),
                                        imageVector = Icons.Outlined.Cookie,
                                        modifier = Modifier.padding(vertical = 12.dp)
                                    )
                                ),
                                IconViewModel(
                                    IconModel(
                                        showIcon = true,
                                        isClickable = Pair(false, null),
                                        imageVector = Icons.Outlined.Cookie,
                                        modifier = Modifier.padding(vertical = 12.dp)
                                    )
                                ),
                                IconViewModel(
                                    IconModel(
                                        showIcon = true,
                                        isClickable = Pair(false, null),
                                        imageVector = Icons.Outlined.Cookie,
                                        modifier = Modifier.padding(vertical = 12.dp)
                                    )
                                )
                            ),
                            hasFloatingAction = IconViewModel(
                                IconModel(
                                    showIcon = true,
                                    isClickable = Pair(false, null),
                                    imageVector = Icons.Outlined.Cookie,
                                    modifier = Modifier
                                )
                            ),
                            modifier = Modifier
                        )
                    )
                }
            }
        },
        content = content
    )
}

@Preview(showBackground = true)
@Composable
fun AppBarsViewPreview() {
    // Mock NavController for preview
    val navController = rememberNavController()
    TP_AppBarView(
        appBarViewModel = com.example.tinypeace.TinyPeaceUI.tinyPeaceData.appBarData.enums.TinyPeaceAppBarType.MediumTopAppBar,
        content = { innerPadding ->

        }
    )
}