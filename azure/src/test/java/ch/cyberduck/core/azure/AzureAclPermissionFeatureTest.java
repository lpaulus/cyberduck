package ch.cyberduck.core.azure;

import ch.cyberduck.core.Path;
import ch.cyberduck.core.exception.NotfoundException;
import ch.cyberduck.test.IntegrationTest;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.EnumSet;
import java.util.UUID;


@Category(IntegrationTest.class)
public class AzureAclPermissionFeatureTest extends AbstractAzureTest {

    @Test(expected = NotfoundException.class)
    public void testReadNotFoundContainer() throws Exception {
        final Path container = new Path(UUID.randomUUID().toString(), EnumSet.of(Path.Type.volume, Path.Type.directory));
        final AzureAclPermissionFeature f = new AzureAclPermissionFeature(session, null);
        f.getPermission(container);
    }
}
