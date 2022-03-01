package ib.firsthelper.Utilities

import java.lang.Exception

class Step(props: String) {



    var id: Int = 0
    var title: String = ""
    var description: String = ""
    var stepType: String = ""

    var audioName: String = ""
    var imageName: String = ""

    var nextStepA: Int = 0
    var nextStepB: Int = 0

    init {
            try {
                val cutted = props.split("$")

                this.id = cutted[0].toInt()
                this.title = cutted[1]
                this.description = cutted[2]
                this.stepType = cutted[3]

                this.audioName = cutted[4]
                this.imageName = cutted[5]

                this.nextStepA = cutted[6].toInt()

                if(cutted.size==8) {
                    this.nextStepB = cutted[7].toInt()
                }else{
                    this.nextStepB=nextStepA
                }
            }catch(e: Exception){
                print("ERROR IN CREATING NEW STEP")
            }
        }


}