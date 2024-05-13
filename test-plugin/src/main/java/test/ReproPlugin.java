package test;

import com.google.gson.Gson;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class ReproPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project.getTasks().create("doSomething", task -> {
            task.doFirst(t -> {
                // Deserialize a record; this requires at least GSON version 2.10.
                t.getLogger().lifecycle("Record is {}", new Gson().fromJson(
                        "{\"x\": 0}",
                        TestRecord.class));
            });
        });
    }
}

record TestRecord(int x) {}
