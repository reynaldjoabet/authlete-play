
// Permissions are now modeled as enums in Scala 3
enum Permission{
  // Dataset-level permissions
  case ViewGraphSchema
  case ManageGraphSchema
  case ManageModelTemplates
  case ManageDatasetTemplates
  case PublishDatasetTemplate
  case CreateDeleteRecord
  case CreateDeleteFiles
  case EditRecords
  case EditFiles
  case ViewRecords
  case ViewFiles
  case ManageCollections
  case ManageRecordRelationships
  case ManageDatasetCollections
  case AddPeople
  case ChangeRoles
  case ViewPeopleAndRoles
  case TransferOwnership
  case ReserveDoi
  case ManageAnnotations
  case ManageAnnotationLayers
  case ViewAnnotations
  case ManageDiscussionComments
  case ViewDiscussionComments
  case EditContributors
  case EditDatasetName
  case EditDatasetDescription
  case EditDatasetAutomaticallyProcessingPackages
  case DeleteDataset
  case RequestRevise
  case RequestCancelPublishRevise
  case ShowSettingsPage
  case ViewExternalPublications
  case ManageExternalPublications
  case ViewWebhooks
  case ManageWebhooks
  case TriggerCustomEvents
  case EditDatasetChangelog
}
  // Organization-level permission(s)
 // case CreateDatasetFromTemplate

object Permission{

  private def rolePermissions(role: Role): Set[Permission] = role match{
    case Role.Viewer =>
      Set(
        //Permission.CreateDatasetFromTemplate,
        Permission.ViewGraphSchema,
        Permission.ViewRecords,
        Permission.ViewFiles,
        Permission.ViewAnnotations,
        Permission.ViewPeopleAndRoles,
        Permission.ManageDiscussionComments,
        Permission.ViewDiscussionComments,
        Permission.ViewExternalPublications,
        Permission.ViewWebhooks
      )
    case Role.Editor =>
      rolePermissions(Role.Viewer) ++ Set(
        Permission.CreateDeleteRecord,
        Permission.CreateDeleteFiles,
        Permission.EditRecords,
        Permission.EditFiles,
        Permission.ManageCollections,
        Permission.ManageRecordRelationships,
        Permission.ManageAnnotations,
        Permission.ManageAnnotationLayers,
        Permission.TriggerCustomEvents
      )
    case Role.Manager =>
      rolePermissions(Role.Editor) ++ Set(
        Permission.ManageGraphSchema,
        Permission.ManageModelTemplates,
        Permission.ManageDatasetTemplates,
        Permission.PublishDatasetTemplate,
        Permission.AddPeople,
        Permission.ChangeRoles,
        Permission.EditDatasetName,
        Permission.EditDatasetDescription,
        Permission.EditDatasetAutomaticallyProcessingPackages,
        Permission.EditContributors,
        Permission.ShowSettingsPage,
        Permission.RequestRevise,
        Permission.ReserveDoi,
        Permission.ManageDatasetCollections,
        Permission.ManageExternalPublications,
        Permission.ManageWebhooks,
        Permission.EditDatasetChangelog
      )
      case Role.Owner =>
        rolePermissions(Role.Manager) ++ Set(
          Permission.TransferOwnership,
          Permission.DeleteDataset,
          Permission.RequestCancelPublishRevise
        )
    }
  
    def hasPermission(role: Role)(permission: Permission): Boolean =
      rolePermissions(role).contains(permission)
  
    def hasPermissions(role: Role)(permissions: Set[Permission]): Boolean =
      permissions.forall(hasPermission(role))
  }

 enum Role{
  case Viewer
  case Editor
  case Manager
  case Owner
 }