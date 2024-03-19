package pl.pw.laa.navigation

import com.ramcosta.composedestinations.annotation.ExternalModuleDestinations
import com.ramcosta.composedestinations.annotation.NavHostGraph

@NavHostGraph
annotation class MyGraph {

	@ExternalModuleDestinations<pl.pw.laa.settings.generated.ModuleDestinations>
	@ExternalModuleDestinations<pl.pw.laa.quiz.generated.ModuleDestinations>
	@ExternalModuleDestinations<pl.pw.laa.alphabet.generated.ModuleDestinations>
	companion object Includes
}