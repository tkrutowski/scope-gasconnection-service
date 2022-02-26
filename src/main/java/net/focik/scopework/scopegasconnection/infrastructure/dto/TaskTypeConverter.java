package net.focik.scopework.scopegasconnection.infrastructure.dto;

import net.focik.scopework.share.TaskType;

import javax.persistence.AttributeConverter;

public class TaskTypeConverter implements AttributeConverter<TaskType, String> {
    @Override
    public String convertToDatabaseColumn(TaskType taskType) {
        return taskType.getDbValue();
    }

    @Override
    public TaskType convertToEntityAttribute(String s) {
        return TaskType.fromDbValue(s);
    }
}
