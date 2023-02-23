module snowpost.homework1 {
    requires com.google.gson;

    opens snowpost.homeworkone to com.google.gson;
    exports snowpost.homework1;
}
