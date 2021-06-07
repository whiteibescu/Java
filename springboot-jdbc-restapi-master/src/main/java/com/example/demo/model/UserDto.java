package com.example.demo.model;

public class UserDto {
    public static class Deleted {
        private Long id;

        public Deleted(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }
}
