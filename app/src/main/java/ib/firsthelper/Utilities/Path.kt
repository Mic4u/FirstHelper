package ib.firsthelper.Utilities

public class Path(props: String) {
/*
* Path takes a string from eg. a txt file and turns it into an array of steps
* The String is made of step block (separated by "|" ) and the step blocks are then divided into parameter blocks by "$"
 */


    var path: MutableList<Step>

    init {

        val spliced: Array<String> = props.split("|").toTypedArray()

        val list: MutableList<Step> = mutableListOf(Step(spliced[0]))

        for ((counter, i) in spliced.withIndex()) {

            var trimed=i.trim()
            list.add(counter, Step(trimed))

        }
        list.removeLast()
        this.path=list
    }


}