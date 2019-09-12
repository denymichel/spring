package com.consultorio.consultorio;

public class NotFound_Consul extends RuntimeException  {
      NotFound_Consul(Long id) {
          super("Could not find employee " + id); }
}

