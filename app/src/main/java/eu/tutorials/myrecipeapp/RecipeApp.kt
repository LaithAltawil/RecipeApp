package eu.tutorials.myrecipeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(NavController: NavHostController){
    val recipeViewModel:MainViewModel= viewModel()
    val viewstate by recipeViewModel.categoriesState
    NavHost(navController = NavController,
        startDestination = Screen.RecipeScreen.route
        ){
        composable(Screen.RecipeScreen.route){
            RecipeScreen(navigatetodetail = {
            NavController.currentBackStackEntry?.savedStateHandle?.set("cat",it)
            NavController.navigate(Screen.DetailScreen.route) },
                viewstate = viewstate)


        }
composable(route = Screen.DetailScreen.route){
    val category=NavController.previousBackStackEntry?.savedStateHandle?.
    get<Category>("cat")?: Category("","","","")
    CategoryDetailScreen(category = category)
}
    }
}
