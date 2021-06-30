/*
 * Files.com API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 0.0.1
 * Contact: support@files.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package ch.cyberduck.core.brick.io.swagger.client.api;

import ch.cyberduck.core.brick.io.swagger.client.ApiException;
import ch.cyberduck.core.brick.io.swagger.client.model.FormFieldSetEntity;
import ch.cyberduck.core.brick.io.swagger.client.model.PatchFormFieldSets;
import ch.cyberduck.core.brick.io.swagger.client.model.PostFormFieldSets;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for FormFieldSetsApi
 */
@Ignore
public class FormFieldSetsApiTest {

    private final FormFieldSetsApi api = new FormFieldSetsApi();

    
    /**
     * Delete Form Field Set
     *
     * Delete Form Field Set
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteFormFieldSetsIdTest() throws ApiException {
        Integer id = null;
        api.deleteFormFieldSetsId(id);

        // TODO: test validations
    }
    
    /**
     * List Form Field Sets
     *
     * List Form Field Sets
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getFormFieldSetsTest() throws ApiException {
        Integer userId = null;
        String cursor = null;
        Integer perPage = null;
        List<FormFieldSetEntity> response = api.getFormFieldSets(userId, cursor, perPage);

        // TODO: test validations
    }
    
    /**
     * Show Form Field Set
     *
     * Show Form Field Set
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getFormFieldSetsIdTest() throws ApiException {
        Integer id = null;
        FormFieldSetEntity response = api.getFormFieldSetsId(id);

        // TODO: test validations
    }
    
    /**
     * Update Form Field Set
     *
     * Update Form Field Set
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void patchFormFieldSetsIdTest() throws ApiException {
        Integer id = null;
        PatchFormFieldSets formFieldSets = null;
        FormFieldSetEntity response = api.patchFormFieldSetsId(id, formFieldSets);

        // TODO: test validations
    }
    
    /**
     * Create Form Field Set
     *
     * Create Form Field Set
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void postFormFieldSetsTest() throws ApiException {
        PostFormFieldSets formFieldSets = null;
        FormFieldSetEntity response = api.postFormFieldSets(formFieldSets);

        // TODO: test validations
    }
    
}
