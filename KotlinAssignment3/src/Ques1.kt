 fun main(args: Array<String>) {
        try {
            Class.forName("com.KotlinAssignment.Ques1")

            ClassLoader.getSystemClassLoader().loadClass("com.KotlinAssignment.Ques1")

            ClassLoader.getSystemClassLoader().loadClass("com.KotlinAssignment.Ques1")
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }

    }

