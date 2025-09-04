# roadmap-todo
A to do list app written in java for roadmap.sh. The specification for the project can be found here:

https://roadmap.sh/projects/task-tracker

<h2>How to run</h2>

You can clone the repo from github and then compile it from the src directory, but I recommend using gradle. You can run the folowing command from the root directory to build and run the project with your args in the quotation marks.

`./gradlew run --args=""`

A note here is that you will need to use a backslash to escape any other quotation marks, for example when inputting the task description e.g.

`./gradlew run --args="add \"tidy up bedroom\""`

<h2>Features</h2>

As per the specification, this project doesn't use any external libraries to parse or write the json. You can see in the FileIOManager class and jsonStringBuilder class how this was achieved.

Rather than working against the json structure, my project works with the structure by checking whether the string in the json is a key in the Task information map and storing the value of the next index in the array if so. I think this is a nice solution because it uses the information present to complete the task, rather than trying to work against it by, say, skipping every other index value. A drawback is that you would need to manually add each key to the Task constructor so, if the Task information ever grew to a large size, it might become hard to manage. In this case, I would move to checking if the map already contains the string as a value and skip it if so; I would then put the string and the next array index into the map to generate the map dynamically.
