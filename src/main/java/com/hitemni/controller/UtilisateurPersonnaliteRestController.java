/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hitemni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hitemni.dao.UtilisateurPersonnaliteI;
import com.hitemni.model.UtilisateurPersonnalite;

@Controller
@RequestMapping("/rest/utilisateurPersonnalites")
public class UtilisateurPersonnaliteRestController {
    @Autowired
    private UtilisateurPersonnaliteI UtilisateurPersonnalite;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<UtilisateurPersonnalite> listAllUtilisateurPersonnalites() {
        return UtilisateurPersonnalite.listeUtilisateurPersonnalite();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody UtilisateurPersonnalite lookupUtilisateurPersonnaliteById(@PathVariable("id") int idutilisateurPersonnalite) {
        return UtilisateurPersonnalite.getUtilisateurPersonnaliteById(idutilisateurPersonnalite);
    }
}
