package com.example.jessschristmasstory

import androidx.compose.runtime.*
import GameTexts
class Story(val goTitleScreen: () -> Unit) {
    var gameState by mutableStateOf("startingPoint")
    var gameText by mutableStateOf("")
    var choiceTexts by mutableStateOf(listOf("", "", "", ""))
    var nextPositions by mutableStateOf(listOf("", "", "", ""))

    // variables
    var ateFood by mutableStateOf(false)
    var getsMagicWord by mutableStateOf(false)
    var getsMysteryBag by mutableStateOf(false)
    var getsBackpack by mutableStateOf(false)
    var getsCompanion by mutableStateOf(false)
    var getsPresent by mutableStateOf(false)

    init {
        selectPosition(gameState)
    }

    fun selectPosition(position: String) {
        gameState = position
        when (position) {
            "startingPoint" -> startingPoint()
            "leaveHouse" -> leaveHouse()
            "getOnTrain" -> getOnTrain()
            "goInside" -> goInside()
            "overslept" -> overslept()
            "goTitleScreen" -> goTitleScreen()
            "early" -> early()
            "justInTime" -> justInTime()
            "slightlyLate" -> slightlyLate()
            "checkText" -> checkText()
            "seePuppy" -> seePuppy()
            "seeBag" -> seeBag()
            "forgotBag" -> forgotBag()
            "goToAerial" -> goToAerial()
            "lunchWithMichael" -> lunchWithMichael()
            "surpriseMe" -> surpriseMe()
            "walkToTheatre" -> walkToTheatre()
            "takeTheSubway" -> takeTheSubway()
            "stuckSubway" -> stuckSubway()
            "openMichaelPresent" -> openMichaelPresent()
            "cocktailPartyEnding" -> cocktailPartyEnding()
            "theatreEnding" -> theatreEnding()
            "keepMoving" -> keepMoving()
            "bagToEar" -> bagToEar()
            "carIntro" -> carIntro()
            "driverChoice" -> driverChoice()
            "stolenPresents" -> stolenPresents()
            "brokenSleigh" -> brokenSleigh()
            "charlesLeftEnding" -> charlesLeftEnding()
            "maxRightEnding" -> maxRightEnding()
            "goDrivingForPresents" -> goDrivingForPresents()
            "charlesDrivesEnding" -> charlesDrivesEnding()
            "jessDrivesCharles" -> jessDrivesCharles()
            "reindeerPitCrew" -> reindeerPitCrew()
            "snowmanPitCrewEnding" -> snowmanPitCrewEnding()
            "rebuyPresentsEnding" -> rebuyPresentsEnding()
            "trueMeaningOfChristmasEnding" -> trueMeaningOfChristmasEnding()
            "fixTheSleighEnding" -> fixTheSleighEnding()
            "goDriveToDeliver" -> goDriveToDeliver()
            "jessDrivesMax" -> jessDrivesMax()
            "maxDrives" -> maxDrives()
            "pleaseEnding" -> pleaseEnding()
            "christmasCracker" -> christmasCracker()
            "magicWord" -> magicWord()
            "beatriceReveal" -> beatriceReveal()
            "christmasSpiritEnding" -> christmasSpiritEnding()
            "fullChaosEnding" -> fullChaosEnding()
            "throwOnGround" -> throwOnGround()
        }
    }

    private fun startingPoint() {
        gameText = GameTexts.startingPoint
        choiceTexts = listOf("I woke up early, actually!", "Woke up just in time", "I may have woken up slightly late", "Overslept completely :(")
        nextPositions = listOf("early", "justInTime", "slightlyLate", "overslept")
    }

    // Wake Up Prompt
    private fun early() {
        gameText = GameTexts.early
        choiceTexts = listOf("Get dressed and let's head out for your day", "", "", "")
        ateFood = true
        nextPositions = listOf("leaveHouse", "", "", "")
    }

    private fun justInTime() {
        gameText = GameTexts.justInTime
        choiceTexts = listOf("Get ready and head out for your day", "", "", "")
        ateFood = true
        nextPositions = listOf("leaveHouse", "", "", "")
    }

    private fun slightlyLate() {
        gameText = GameTexts.slightlyLate
        choiceTexts = listOf("Run out the door, hustle!", "Ugh, just go back to bed and try again tomorrow", "", "")
        nextPositions = listOf("leaveHouse", "startingPoint", "", "")
    }
    private fun overslept() {
        gameText = GameTexts.overslept
        choiceTexts = listOf("Try again tomorrow", "", "", "")
        nextPositions = listOf("startingPoint", "", "", "")
    }

    private fun leaveHouse() {
        gameText = GameTexts.leaveHouse
        choiceTexts = listOf("Oh look! Sarah messaged me", "Oh my god! LOOK! AT! THAT! PUPPY!", "Wait... that bag looks kinda weird, but I can't look away", "Shit, I don't have my backpack")
        nextPositions = listOf("checkText", "seePuppy", "seeBag", "forgotBag")
    }

    private fun checkText() {
        gameText = GameTexts.checkText
        choiceTexts = listOf("Nice! Let's head to the train", "", "", "")
        getsMagicWord = true
        nextPositions = listOf("getOnTrain", "", "", "")
    }
    private fun seePuppy() {
        gameText = GameTexts.seePuppy
        choiceTexts = listOf("Nice! Let's head to the train", "", "", "")
        nextPositions = listOf("getOnTrain", "", "", "")
    }
    private fun seeBag() {
        gameText = GameTexts.seeBag
        choiceTexts = listOf("Nice! Let's head to the train", "", "", "")
        getsMysteryBag = true
        nextPositions = listOf("getOnTrain", "", "", "")
    }
    private fun forgotBag() {
        gameText = GameTexts.forgotBag
        choiceTexts = listOf("Go back inside and get your bag", "", "", "")
        nextPositions = listOf("goInside", "", "", "")
    }

    private fun goInside() {
        gameText = GameTexts.goInside
        choiceTexts = listOf("Nice! Let's head to the train", "", "", "")
        getsBackpack = true
        nextPositions = listOf("getOnTrain", "", "", "")
    }

    // Get on Train
    private fun getOnTrain() {
        gameText = GameTexts.getOnTrain
        choiceTexts = listOf("I have an aerial class!", "I have lunch plans with Michael", "Wait... I can't remember... what *was* I meant to do today??", "")
        nextPositions = listOf("goToAerial", "lunchWithMichael", "surpriseMe", "")
    }

    private fun goToAerial() {
        if (!ateFood) {
            gameText = GameTexts.goToAerialNoFood
            choiceTexts = listOf("Try again tomorrow", "", "", "")
            nextPositions = listOf("startingPoint", "", "", "")
        } else {
            gameText = GameTexts.goToAerialFood
            choiceTexts = listOf("Let's go", "", "", "")
            nextPositions = listOf("lunchWithMichael", "", "", "")
        } }

    private fun lunchWithMichael() {
        if (!getsBackpack) {
            gameText = GameTexts.lunchWithMichaelNoPresent
            choiceTexts = listOf("Go home and let's try again tomorrow", "", "", "")
            nextPositions = listOf("startingPoint", "", "", "")
        } else {
            gameText = GameTexts.lunchWithMichaelPresent
            getsPresent = true
            choiceTexts = listOf("I think I'll walk to the theatre", "It's kind of chilly, I should take the subway", "", "")
            nextPositions = listOf("walkToTheatre", "takeTheSubway", "", "")
        } }
    private fun walkToTheatre() {
        gameText = GameTexts.walkToTheatre
        // sample text to test
        choiceTexts = listOf("Open the present", "Nope, Sarah looks so hot I can't stop looking at her until the show starts. Wow, my girlfriend is *so* hot", "", "")
        nextPositions = listOf("openMichaelPresent", "theatreEnding", "", "")
    }
    private fun openMichaelPresent() {
        gameText = GameTexts.openMichaelPresent
        // sample text to test
        choiceTexts = listOf("Yes!", "Nope, I just want to stay with Sarah", "", "")
        nextPositions = listOf("cocktailPartyEnding", "theatreEnding", "", "")
    }
    private fun cocktailPartyEnding() {
        gameText = GameTexts.cocktailPartyEnding
        // sample text to test
        choiceTexts = listOf("Want another festive day?", "", "", "")
        nextPositions = listOf("startingPoint", "", "", "")
    }
    private fun theatreEnding() {
        gameText = GameTexts.theatreEnding
        choiceTexts = listOf("Want another festive day?", "", "", "")
        nextPositions = listOf("startingPoint", "", "", "")
    }


    private fun takeTheSubway() {
        gameText = GameTexts.takeTheSubway
        choiceTexts = listOf("Stay on the subway, it's cold and I cannot be bothered to go outside again", "This is so annoying, I'll just get out and walk", "", "")
        nextPositions = listOf("stuckSubway", "walkToTheatre", "", "")
    }
    private fun stuckSubway() {
        gameText = GameTexts.stuckSubway
        choiceTexts = listOf("Try again tomorrow", "", "", "")
        nextPositions = listOf("startingPoint", "", "", "")
    }


    private fun surpriseMe() {
        if (!getsMysteryBag) {
            gameText = GameTexts.surpriseMeNoBag
            choiceTexts = listOf("Great, let's get lunch with Michael!", "", "", "")
            nextPositions = listOf("lunchWithMichael", "", "", "")
        } else {
            gameText = GameTexts.surpriseMeBag
            choiceTexts = listOf("Hold the bag up to your ear", "Ignore it and just keep moving", "Throw the bag on the ground, scream and run away", "")
            nextPositions = listOf("bagToEar", "keepMoving", "throwOnGround", "")
        } }

    private fun throwOnGround() {

        gameText = GameTexts.throwOnGround
        choiceTexts = listOf("Try again tomorrow", "", "", "")
        nextPositions = listOf("startingPoint", "", "", "")
    }

    private fun keepMoving() {
        gameText = GameTexts.keepMoving
        choiceTexts = listOf("Is... that the sound of braking??", "", "", "")
        nextPositions = listOf("carIntro", "", "", "")
    }
    private fun bagToEar() {
        gameText = GameTexts.bagToEar
        getsCompanion = true
        choiceTexts = listOf("A talking cat??", "", "", "")
        nextPositions = listOf("carIntro", "", "", "")
    }

    private fun carIntro(){
        gameText = GameTexts.carIntro
        choiceTexts = listOf("Wait... what is that sound?", "", "", "")
        nextPositions = listOf("driverChoice", "", "", "")
    }


    private fun driverChoice(){
    // if getCompanion is not true, we go down the Charles path
        if (!getsCompanion) {
            gameText = GameTexts.driverChoiceNoCompanion
            choiceTexts = listOf("Take a right", "Take a left", "", "")
            nextPositions = listOf("stolenPresents", "charlesLeftEnding", "", "")
        }
        // if getCompanion is  true, we go down the Max path
        else {
            gameText = GameTexts.driverChoiceCompanion
            choiceTexts = listOf("Turn left", "Turn right", "", "")
            nextPositions = listOf("brokenSleigh", "maxRightEnding", "", "")
        } }

    private fun stolenPresents(){
        gameText = GameTexts.stolenPresents
        choiceTexts = listOf("You suggest driving around and looking for the presents", "We should just re-buy all of the presents, right?", "You tell them that the true meaning of Christmas is about relationships, and not presents", "")
        nextPositions = listOf("goDrivingForPresents", "rebuyPresentsEnding", "trueMeaningOfChristmasEnding", "")
    }

    private fun goDrivingForPresents() {
        gameText = GameTexts.goDrivingForPresents
        choiceTexts = listOf("Of course we will, I'm going to drive", "Of course we will, Charles is going to drive", "", "")
        nextPositions = listOf("jessDrivesCharles", "charlesDrivesEnding", "", "")
    }

    private fun rebuyPresentsEnding(){
        gameText = GameTexts.rebuyPresentsEnding
        choiceTexts = listOf("Want another festive day?", "", "", "")
        nextPositions = listOf("startingPoint", "", "", "")
    }
    private fun trueMeaningOfChristmasEnding(){
        gameText = GameTexts.trueMeaningOfChristmasEnding
        choiceTexts = listOf("Want another festive day?", "", "", "")
        nextPositions = listOf("startingPoint", "", "", "")
    }
    private fun charlesDrivesEnding() {
        gameText = GameTexts.charlesDrivesEnding
        choiceTexts = listOf("Try again tomorrow", "", "", "")
        nextPositions = listOf("startingPoint", "", "", "")
    }
    private fun jessDrivesCharles(){
        gameText = GameTexts.jessDrivesCharles
        choiceTexts = listOf("The reindeer pit crew", "The snowman pit crew", "", "")
        nextPositions = listOf("reindeerPitCrew", "snowmanPitCrewEnding", "", "")
    }
    private fun reindeerPitCrew() {
        gameText = GameTexts.reindeerPitCrew
        choiceTexts = listOf("Want another festive day?", "", "", "")
        nextPositions = listOf("startingPoint", "", "", "")
    }
    private fun snowmanPitCrewEnding() {
        gameText = GameTexts.snowmanPitCrewEnding
        choiceTexts = listOf("Try again tomorrow", "", "", "")
        nextPositions = listOf("startingPoint", "", "", "")
    }

    //
    private fun charlesLeftEnding() {
        gameText = GameTexts.charlesLeftEnding
        choiceTexts = listOf("Try again tomorrow", "", "", "")
        nextPositions = listOf("startingPoint", "", "", "")
    }

    private fun brokenSleigh(){
        gameText = GameTexts.brokenSleigh
        choiceTexts = listOf("You tell them about the real meaning of Christmas", "You suggest delivering presents in the car", "You offer to help them fix the sleigh", "")
        nextPositions = listOf("trueMeaningOfChristmasEnding", "goDriveToDeliver", "fixTheSleighEnding", "")
    }

    private fun maxRightEnding() {
        gameText = GameTexts.maxRightEnding
        choiceTexts = listOf("Try again tomorrow", "", "", "")
        nextPositions = listOf("startingPoint", "", "", "")
    }

    private fun fixTheSleighEnding() {
        gameText = GameTexts.fixTheSleighEnding
        choiceTexts = listOf("Want another festive day?", "", "", "")
        nextPositions = listOf("startingPoint", "", "", "")
    }

    private fun goDriveToDeliver() {
        gameText =  GameTexts.goDriveToDeliver
        choiceTexts = listOf("Of course we will, I'm going to drive", "Of course we will, Max is going to drive", "", "")
        nextPositions = listOf("jessDrivesMax", "maxDrives", "", "")
    }

    private fun jessDrivesMax() {
        gameText = GameTexts.jessDrivesMax
        choiceTexts = listOf("Try again tomorrow", "", "", "")
        nextPositions = listOf("startingPoint", "", "", "")
    }

    private fun maxDrives() {
        gameText = GameTexts.maxDrives
        choiceTexts = listOf("The magic word??? Please", "I've got this, the magic word is peppermint", "Easy, the magic word is frosty", "I've got this, the magic word is christmasCracker")
        nextPositions = listOf("pleaseEnding", "magicWord", "magicWord", "christmasCracker")
    }

    private fun pleaseEnding(){
        gameText = GameTexts.pleaseEnding
        choiceTexts = listOf("Want another festive day?", "", "", "")
        nextPositions = listOf("startingPoint", "", "", "")
    }

    private fun christmasCracker(){
        if (!getsMagicWord) {
            gameText = GameTexts.christmasCrackerNoMagicWord
            choiceTexts = listOf("Want another festive day?", "", "", "")
            nextPositions = listOf("startingPoint", "", "", "")
        }
        else {
            gameText = GameTexts.christmasCrackerMagicWord
            choiceTexts = listOf("Want another festive day?", "", "", "")
            nextPositions = listOf("startingPoint", "", "", "")
        }
    }
    private fun magicWord(){
        gameText = GameTexts.magicWord
        choiceTexts = listOf("Wait... how do you know Sarah?", "", "", "")
        nextPositions = listOf("beatriceReveal", "", "", "")
    }
    private fun beatriceReveal(){
        gameText = GameTexts.beatriceReveal
        choiceTexts = listOf("Appeal to Beatrice's Christmas Spirit, and sing a festive song to her", "Fuck it, full chaos", "", "")
        nextPositions = listOf("christmasSpiritEnding", "fullChaosEnding", "", "")
    }
    private fun christmasSpiritEnding(){
        gameText = GameTexts.christmasSpiritEnding
        choiceTexts = listOf("Want another festive day?", "", "", "")
        nextPositions = listOf("startingPoint", "", "", "")
    }
    private fun fullChaosEnding(){
        gameText = GameTexts.fullChaosEnding
        choiceTexts = listOf("Want another festive day?", "", "", "")
        nextPositions = listOf("startingPoint", "", "", "")
    }
    private fun goTitleScreen() {
        goTitleScreen.invoke()
    }
}
